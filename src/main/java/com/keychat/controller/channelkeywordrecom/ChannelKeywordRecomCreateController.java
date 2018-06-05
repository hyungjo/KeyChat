package com.keychat.controller.channelkeywordrecom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet(urlPatterns = "/channelKeywordRecom/create")
public class ChannelKeywordRecomCreateController extends HttpServlet {
	public ChannelKeywordRecomCreateController() {
        super();
    }
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                "2018-03-16",
                "cbb20eb6-c3cb-42bf-96db-7438bc3d87aa",
                "x1odk2Nz1TxM"
        );

        String text = "올해부터 대학 축제에서 술을 못 판대 안 좋은것같아" + 
        		"술을 못 파는 것 땜에 축제가 재미있을 지 모르겠어" + 
        		"맞아 대학 축제는 연예인 공연 보면서 술마시는 재미인데" + 
        		"그런데 주점 신고 안하고 술을 판매했던 것도 잘못된 일인 것 같아" + 
        		"내가 알기로는 학생회장이 그 책임을 다 가지고 진행해왔었대" + 
        		"학교에서 술을 마시는게 문제였던 걸까" + 
        		"과음을 해서 문제가 된 걸까" + 
        		"hello." + 
        		"미성년자에게도 술이 쉽게 노출될 수 있어서 그런 것 일수도 있어" + 
        		"맞아 고등학생들이 축제에 와서 술먹는 것을 봤었어" + 
        		"응 요즘 고등학생들은 너무 성숙해서 구별하기 힘들더라"; 

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
        
        

        //Sync
//        AnalysisResults res = service
//                .analyze(parameters)
//                .execute();

        //Async
        
        
        ServiceCall call = service.analyze(parameters);
        call.enqueue(new ServiceCallback<AnalysisResults>() {
            @Override public void onResponse(AnalysisResults res) {
                System.out.println(res);
                Gson gson = new Gson();
                
                Map<String, String> entities = new HashMap<String, String>();
                Map<String, String> keywords = new HashMap<String, String>();
                Map<String, String> categories = new HashMap<String, String>();
                
                /*entities = (Map<String, String>) gson.fromJson(res, res.entities);*/
            }
            @Override public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
    }

   /* @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }*/
}
