package com.hotnerds.badgeload.naver;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open")
public class OpenApiController {
    @Autowired
    NaverClient naver = new NaverClient();

    @ResponseBody
    @GetMapping("naver/blog")
    public ResponseEntity<JSONObject> getPlace(@RequestParam("query") String query) throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(naver.searchBlog(query));
        JSONObject jsonObj = (JSONObject) obj;
        return ResponseEntity.ok(jsonObj);
    }

    @ResponseBody
    @GetMapping("/naver/image")
    public ResponseEntity<JSONObject> getImage(@RequestParam("query") String query) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject)parser.parse(naver.searchImage(query));
        return ResponseEntity.ok(jsonObj);
    }

    @ResponseBody
    @GetMapping("/naver/local")
    public ResponseEntity<JSONObject> getLocal(@RequestParam("query") String query) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject)parser.parse(naver.searchLocal(query));
        return ResponseEntity.ok(jsonObj);
    }
}
