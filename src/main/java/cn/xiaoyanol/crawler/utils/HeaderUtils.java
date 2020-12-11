package cn.xiaoyanol.crawler.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: chenyanfeng
 * @Date: 2019-08-14
 * @Time: 下午3:05
 */
public class HeaderUtils {

    public static Map<String, String> getHeaders(String authorization) {

        // 设置请求参数 0###oo34J0ZRgatN5UBO8UQRwap6Ew_A###1565664617903###24ed6f7b1512aee63869b97552a2bd8f
        Map<String, String> headers = new HashMap<>();
//        headers.put("Authorization", authorization);
        headers.put("host", "api9.tianyancha.com");
        headers.put("Content-Type", "application/json");
//   before:  headers.put("X-AUTH-TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODIxMTI0NDg2NiIsImlhdCI6MTU1Nzc0Mzc2NCwiZXhwIjoxNTYwMzM1NzY0fQ.BACR-0C0uRCbINF6Lv-aZ4Tz16TYhxrUyhWZ7D2rm9F4kIkZtwIjqePPj_WXVIhtYDQhkXbtEBaldpq9fnAT-A");

        Random random = new Random();
        int j = random.nextInt(3);
        if (j == 1) {
            // liyun
            headers.put("Authorization", "0###oo34J0fFDKXx5Z-2PJTtCnw2n-0Y###1607323308193###1946c7a6e21b36be2794687af026ed29");
            headers.put("X-AUTH-TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODc3OTkxMzcxMyIsImlhdCI6MTYwNzMzMTU3NiwiZXhwIjoxNjA5OTIzNTc2fQ.HO8YjIfvyIrMdpxM4oKKYWBf1Rjs53QyRGCz6OhxC7jMs4q6csXYHXE6StfDjSAbHip4kmy45lzvp-V44631gA");
        }
        if (j == 0) {
            // my
            headers.put("Authorization", "0###oo34J0SZrKScRTJU2u2eEqfuXcgY###1607334955311###17237e17bffd86276115925c58e8bc60");
            headers.put("X-AUTH-TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTMyMzM0MTM1NiIsImlhdCI6MTYwNzMyODQ4NywiZXhwIjoxNjA5OTIwNDg3fQ.OX2XbZ1c0Q4aVbb7txE6tqnrhLjvQrHKrH15RWM-Ew5rghnwKdhVcAONYQp412nIV4G8TE284m23mceJVRc5aw");
        }
        if (j == 2) {
            // junwu
            headers.put("Authorization", "0###oo34J0YUxIFVop3EAbdLvlKvN87Y###1607334158925###4ee2fd840e1c9b481971f38c3e1e62f7");
            headers.put("X-AUTH-TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODY3NTUxOTMzMSIsImlhdCI6MTYwNzMzNDIxNiwiZXhwIjoxNjA5OTI2MjE2fQ.-qqEYe7bkvPFVGgODX3WCcStOoPpbNI8uOVbMkKsodayhaApRUTI97fMvCUOnnk3OHkyKyLBeehl4ksUZK1LsQ");
        }
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept", "*/*");
        headers.put("version", "TYC-XCX-WX");
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 MicroMessenger/7.0.5(0x17000523) NetType/WIFI Language/zh_CN");
        headers.put("Accept-Language", "zh-cn");
        return headers;
    }
}
