import com.github.kevinsawicki.http.HttpRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class WxOpenData {
    @RequestMapping(value = "/WxOpenData")
    public String getWxOpenData(@RequestParam(value = "js_code",required = true) String js_code){
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", WxMiniConfig.AppId);
        data.put("secret", WxMiniConfig.AppSecret);
        data.put("js_code", js_code);
        data.put("grant_type", "authorization_code");

        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(data).body();

        //JSONObject obj= JSON.parseObject(response);//将json字符串转换为json对
        return response.toString();
    }

}