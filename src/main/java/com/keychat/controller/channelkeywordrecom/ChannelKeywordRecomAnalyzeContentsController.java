package com.keychat.controller.channelkeywordrecom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dao.base.ChannelsKeywordRecomDao;
import com.keychat.dto.base.*;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelKeywordRecom/analyzeContents", asyncSupported = true)
public class ChannelKeywordRecomAnalyzeContentsController extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext asyncContext = request.startAsync();

		request.setCharacterEncoding("UTF-8");
		ChannelChatHistoryReadModel channelChatHistoryReadModel = JsonUtil.getModelFromJsonRequest(request, ChannelChatHistoryReadModel.class);

    	String contents = ChannelsChatHistoryDao.getHistory(channelChatHistoryReadModel);
		System.out.println(contents);
    	NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                "2018-03-16",
                "cbb20eb6-c3cb-42bf-96db-7438bc3d87aa",
                "x1odk2Nz1TxM"
        );

        String text = contents; 

        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                .limit(5)
                .build();
        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .limit(5)
                .build();
        CategoriesOptions categories = new CategoriesOptions();
        Features features = new Features.Builder()
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .categories(categories)
                .build();
        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(text)
                .features(features)
                .build();
        
        ServiceCall call = service.analyze(parameters);
        call.enqueue(new ServiceCallback<AnalysisResults>() {
			ResponseModel responseModel = null;

			@Override 
			public void onResponse(AnalysisResults res) {
				int size = res.getKeywords().size();
				ArrayList<String> keyword = new ArrayList<String>();
            	for (int i = 0; i<size; i++) {
					keyword.add(res.getKeywords().get(i).getText());
					ChannelsKeywordRecomModel channelsKeywordRecomModel1 = new ChannelsKeywordRecomModel(0, res.getKeywords().get(i).getText(), channelChatHistoryReadModel.getChannelName(), null);
					ChannelsKeywordRecomDao.saveKeyword(channelsKeywordRecomModel1);
            	}

				int size2 = res.getEntities().size();
				ArrayList<String> entity = new ArrayList<String>();
				for (int j = 0; j<size2; j++) {
					entity.add(res.getEntities().get(j).getText());
					ChannelsEntitiesModel channelsEntitiesModel = new ChannelsEntitiesModel(0, res.getEntities().get(j).getText(), channelChatHistoryReadModel.getChannelName(), null);
					ChannelsKeywordRecomDao.saveEntity(channelsEntitiesModel);
				}

            	int size3 = res.getCategories().size();
				ArrayList<String> midCategory = new ArrayList<String>();
            	for (int i = 0; i<size3; i++) {
            		midCategory.add(res.getCategories().get(i).getLabel().split("/")[1]);
					ChannelsCategoriesModel channelsCategoriesModel = new ChannelsCategoriesModel(0, res.getCategories().get(i).getLabel().split("/")[1], channelChatHistoryReadModel.getChannelName(), null);
						ChannelsKeywordRecomDao.saveCategory(channelsCategoriesModel);
				}

				NLAResultModel nlaResultModel = new NLAResultModel(keyword, entity, midCategory);
				responseModel = new ResponseModel(200, "success", "done");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				try {
					response.getWriter().write(new Gson().toJson(responseModel));
				} catch (IOException e) {
					e.printStackTrace();
				}

				asyncContext.complete();
            }
            @Override public void onFailure(Exception e) {
                e.printStackTrace();
				try {
					response.sendError(500, new ResponseModel(500, "fail", "Cannot create channel").toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				asyncContext.complete();
            }
        });
    }
}
