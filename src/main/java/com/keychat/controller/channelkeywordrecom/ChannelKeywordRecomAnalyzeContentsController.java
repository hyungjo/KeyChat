package com.keychat.controller.channelkeywordrecom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dao.base.ChannelsKeywordRecomDao;
import com.keychat.dto.base.ChannelsKeywordRecomModel;

@WebServlet(urlPatterns = "/channelKeywordRecom/analyzeContents")
public class ChannelKeywordRecomAnalyzeContentsController extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String channel_name = request.getParameter("channel_name").trim();
    	String contents = ChannelsChatHistoryDao.getHistory(channel_name);
    	System.out.println(channel_name);
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
			@Override 
			public void onResponse(AnalysisResults res) {
				ArrayList<String> keylist = new ArrayList<String>();
				ArrayList<String> categories = new ArrayList<String>();

				int size = res.getKeywords().size();
            	for (int i = 0; i<size; i++) {
					String keyword1 = res.getKeywords().get(i).getText().toString();
					System.out.println(keyword1);
					ChannelsKeywordRecomModel channelsKeywordRecomModel1 = new ChannelsKeywordRecomModel(0, keyword1, channel_name, null);
					try {
						ChannelsKeywordRecomDao.saveKeyword(channelsKeywordRecomModel1);
						System.out.println("000111000");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					int size2 = res.getEntities().size();
	            	for (int j = 0; j<size2; j++) {
						String keyword2 = res.getEntities().get(j).getText().toString();
						System.out.println(keyword2);
						ChannelsKeywordRecomModel channelsKeywordRecomModel2 = new ChannelsKeywordRecomModel(0, keyword2, channel_name, null);
						try {
							ChannelsKeywordRecomDao.saveKeyword(channelsKeywordRecomModel2);
							System.out.println("00000");
						} catch (SQLException e) {
							e.printStackTrace();
						}
	            	}
            	}
            	int size3 = res.getCategories().size();
            	for (int i = 0; i<size3; i++) {
				String keyword2 = res.getCategories().get(i).toString();
				categories.add(keyword2);
            	}
            }
            @Override public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
