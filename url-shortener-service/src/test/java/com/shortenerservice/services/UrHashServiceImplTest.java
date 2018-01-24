package com.shortenerservice.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrHashServiceImplTest {

    UrlHashServiceImpl urlHashService;

    @Before
    public void setUp() throws Exception {
        urlHashService = new UrlHashServiceImpl();
    }

    @Test
    public void hash() throws Exception {
        //Arrange
        String basicUrl = "https://www.cnn.com";

        //Act
        String id = urlHashService.hash(basicUrl);

        //Assert
        Assert.assertNotNull(id);
        Assert.assertNotEquals(id,"");
    }

    @Test
    public void consistencyHash() throws Exception {
        //Arrange
        String basicUrl = "https://www.cnn.com";

        //Act
        String id1 = urlHashService.hash(basicUrl);
        String id2 = urlHashService.hash(basicUrl);

        //Assert
        Assert.assertNotNull(id1);
        Assert.assertNotNull(id2);
        Assert.assertNotEquals(id1,"");
        Assert.assertNotEquals(id2,"");
        Assert.assertEquals(id1,id2);
    }

    @Test
    public void differentStringsHash() throws Exception {
        //Arrange
        String basicUrl1 = "https://www.cnn.com";
        String basicUrl2 = "https://www.cnn1.com";

        //Act
        String id1 = urlHashService.hash(basicUrl1);
        String id2 = urlHashService.hash(basicUrl2);

        //Assert
        Assert.assertNotNull(id1);
        Assert.assertNotNull(id2);
        Assert.assertNotEquals(id1,"");
        Assert.assertNotEquals(id2,"");
        Assert.assertNotEquals(id1,id2);

    }

    @Test
    public void nullStringHash() throws Exception {
        //Arrange
        //Act
        try {
            String id = urlHashService.hash(null);
            //Assert
            Assert.assertNotNull(id);
            Assert.assertNotEquals(id,"");
            Assert.assertTrue(false);
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void oneLetterHash() throws Exception {
        //Arrange
        String basicUrl = "a";

        //Act
        String id = urlHashService.hash(basicUrl);

        //Assert
        Assert.assertNotNull(id);
        Assert.assertNotEquals(id,"");
    }

    @Test
    public void specialCharsHash() throws Exception {
        //Arrange
        String basicUrl = "✿ ☺ ☻ ☹ ☼ ☂ ☃ ⌇ ⚛ ⌨ ✆ ☎ \uF8FF ⌘ ⌥ ⇧ ↩ ✞ ✡ ☭ ← → ↑ ↓ ➫ ⬇ ⬆ ☜ ☞ ☝ ☟ ✍ ✎ ✌ ☮ ✔ ★ ☆ ♺ ⚑ ⚐ ✉ ✄ ⌲ ✈ ♦ ♣ ♠ ♥ ❤ ♡ ♪ ♩ ♫ ♬ ♯ ♀ ♂ ⚢ ⚣ ❑ ❒ ◈ ◐ ◑ ✖ ∞ « » ‹ › “ ” ‘ ’ „ ‚ – — | ⁄ \\ [ ] { } § ¶ ¡ ¿ ‽ ⁂ ※ ± × ~ ≈ ÷ ≠ π † ‡ ¥ € $ ¢ £ ß © ® @ ™ ° ‰ ";

        //Act
        String id = urlHashService.hash(basicUrl);

        //Assert
        Assert.assertNotNull(id);
        Assert.assertNotEquals(id,"");
    }

    @Test
    public void longStringHash() throws Exception {
        //Arrange
        String basicUrl = "krsY2hFXWer7A33eyH83x8peXAeexDrlpYAbUHZYAucJ4lOZYjm8YvCojT922BMaBsmYPOBzlgbR5ev33z0HCLgNWAKuaDocUHq2fScqqXhIiH93iUDQjc9pvVXekrxRDtgfUz2ePIEWJAewtVJpcpqleZo8AP0Yooe75KztOXPswtNSuS1iW3SBc5ZqXbLBxvv69mfTzr3NYSVvJRRylQ4eCUaDuJUB6WRv83nED5LiyU7VNtAnnlbJFShZrbKhGvSrqIwnrOIxTFu93xaIPZMPzO6MzaCovBNRrHkfuyQhxuw8g4qtCcHjbFS97HaJTW8k77U3WMhinOw7DRhz7Z0p2SYNgZ5SMeB8Dr1qg0pRM5G7cRTAy8tUXnnTb3imtHRglS42FsmHSBQAI6OYYR5NYWt3RCV6MGl119ekED69pIBCTUyLD0sg1E6KbqF3hraaEDqLM59qevmGOBOgeQTGJKAVajiD19su5GXYD7JRCGiS5keXJt1busmqIVfCWHoYkU4TxzG5PVqUQVgCBND0ygcww7CmtQPjONZFFlC24PiqUC0bbEwpqOLna63TP5T2nrt4fSyvIHXjXVXK39WLen3F4kSvbCYV4QRU9LzYTBiD2RnXRKLPXsAxX7ozEp8kWFHmakKM1uwhSUtPXTRQcV7JZQwos4mvGUlt5SDw33uhQ60wcAoZuPKfI1geB7r63qP0J2lulBOWWeiuNSJ4BoQ1Kyzq2gDKR04M3pzRt5Rr3a9VejJAxPqNazsakRMWUZSoFFo0jKPJiGvKOCUSj1CW2ERNGeGHFfHBQqbMubS584CwRW7puKtEBvoHBt8YJIPNgFzbREsObabjOzgaKVginhYUIERvKfTH6YQLz6e3KwWEpCH8328Ok9OHnSf8GyJS0bmbilItWsNk76RmeE7W8OL1Vu5P6TtF6PKfhReD4TihVEgNiA1IbJcrs3EUSBvUVzywzbULZmOvQj5MHyLPoosbsTTvE0FM\n" +
                "CcwWs7NC4EIeeulHcWF1c5mnc2kAhfgXnxXFwNMq6H8oRxZnTotxXfFVOHvvTZ6s5pQEYgRbex4MA1SWUQNUCjLHwC142RmBG3ro7qi4CCUwC0vozKlOwzM08hlD8ImjIyzYR6gm7RuulebNNMXhnGXaXKIuMANQ0xXJZktyf159fkPvlxTVzfq3AHhNLisRZUEpIwxLS6WllZXYeNROvMiF9Mt9DxUCOOGoUApFJRYAXCtPNqjzTuCPLvYJavsYWxRf6GcC9htxtF6n7pmCXMrbmcIRzpnwFaR7mhz5GLXWSgWu5tPAbCE1yTnDqxrBsXlKufwWK13hq2JEssfmTSKwEjTQCyq4Hxv81vBDscNN2yQ2S27I1HON9Fakh6bwB3pgFTyV7mMaPltjxSPeSooEhTNFWUZOlUchBijIQaIsAz9anSZX5YKFhy3wCXxDWaT8SKHCaHc9plM5EN5MZ1CZ8ksjtnBDK0NHpRHe9uEFZ5YUIvoRfLTw76nWb33q0fVAOUnx6rWER5IIIxtZPJYNWlglRnQuN0fwaxPHOJAF3PLiCSEGRG5iFztxSurbgqH4ziYlBhZSp4xCRmH0qHTKpXqZiMHU1fc2gJil8plqQcns2iSJ4A47e65IY7Xq4tRScMgRahXZSM6U0ach3XVOVgILkBOFeey4U33ssu1v0TQpyKgw1ZhRe0qmXxTyphZXFVxOuysJz3LTVB17jymn3JTsHTokmXGqp7SQzCgQv3IPB0DY4rtXXxewScAa5y3kFMIVCzqXweeoM91ovcJFUM7eIk6RayhXHXBIkhgNOI8ELv3Y1VLuXFE9Lkp4Fy4hyblClRO2EDYZP0LQohFI9iOsIPsz8p7PU80eTqhv8PSjqNyn8yIkpgurtvpguACOUPftc0VmBXlr7xgZKbMUjxULEzCoIjywY3hB2M7yKOvMEJvAZmokwLokzTDKyrb4ojqPh2LP3olMAVV6ECWHztlJ5oyVNHZhTjYH\n" +
                "ZxuWwHfxnyeb8TWzqY2SuLvplb9B7n5cmxGarvah7X6qKauuLkKkMSQZLJNgeXUXNGr0ItMnarsJMVU9VKHyXU6EZ72zeqYekfJvE4qwLSOyhCmZCSre1xBCJVEShejItoYCuR4lCARWPcrjeb6GcGQ8pouYTKbsc0Vyoxw2rJTbkU1Hteqi0qhTyka4bg2OjTB2x9UznEQOTMMP36FNMhsiOqwyHPyXjID1ati3MhLchkwAPYCzra5z0tgN8g64PrlNwjDHazg6F2l8xuCoSNl06htm0GJRFugEkU0n89VPCG3iG8OhDaBYxRvo0mM87fm6YTHF6lD37mD6Gso8FMoF1eyhwoDyXEVavsSahu74ARFkM5ZJ35s5N3iicxCDaHZYv8hU3GOEEi105h3viAuhXzaNR0Qr9ozhwv330xrBJLLQq61fODDiCGt2VIkJqp3GnyF6cOpca4wAVIBfSqYnV9tgCaQSjvXWNxtHyi4WQrlHxgjvZD8KCX7x00RtiJXzKLKWGJqozpy35UcwQRGf8FqteBUG3ryeTvDAS2Gv49wco6fWUqXxCA7eaTV9lsioH3wJTrDXNARgepijEGF5aJK66EZ5WRhs6EM1B80F5lk7qi3ESY1jwuHqhH5FoR39yBPvsA1nQX5zcvXvH870ZVMUoNtaeJWtLELBt87EaWYnnKrDRVTcpFasG4rYlYDiEDBhm8xAwcTXvuqoPSQbvpcqaW7cT2y4RCabilw60rLRJ7WDy78hOteiAYzsko8UP5Flrqe9nwY4G7HPQioeZXmgKwQoOcJNbz4INoKk5wj030qzE5HS1oPZVfUfiwMFfKPOKwJ2HwFLr95PyhgEflLfriifLiRjYLaG1uyvFXCMkgEaiZKwyKmurvUw6SAc6uVxLgDfp27GkRNkwAOjPJMMhBWMBTqjNzvNtkBKb8Q4cwD8X4aeC1v1MSjMl2vrmNrJNJC7NcEQzpCXJLr0EqSvZIw3bBWCB8vm\n" +
                "oNH6Cniy0ybFYFVFICGuESaTXnYO40c94ZTDm4hhBv57Gx3XKkuM2Bq1ROs6tpINeDhWD6wEUhYPIOiMxYCRg8jzgZS7sFywnwLgJVBCxHB8SExjKbyJtf01WtnGuah9hRtumrPJ9Flf6uCkvUuyxF5nbABblFjbCmXlTtQ1y3A4HSXA3rwF4N6i5GUvuEIZSiNZz0n2VtWYiRBOemMWbn9QpcVO1kAQ6q7ipi5N5KnVTOX5Wse7avM4jre0yVDo5Tyr8YZGGzw0Wf99OBqxs7M3fYmFmXglnugGZ2LtlnEx6kzkevTDZxUuwOAYVFkWQvYwjyrJ5asbnOpv5lIKcBysFe9TSZSNjRH8Bk1BsAxQffb15eFqEH9nabl5BpRTqpXBKRXsJ82B8ejty8UuaOZrPBwg8NHxuDnX7QCtk6I0xBTurnHnqwRf8rFULOQbhTyqY9HFWMXchFVXhGemLUPYmCwOoLpaPBzfWmDp0K9sV6zyFLQ4a9NelPlBjC9rOYqRQYy22rowfHUUp4YUGcppxmi1EmhGSZUjspxnogAP6vizL5cTMRRxOI7FpMy5LgNZz9l4JM0gXT1spe6UDaMzhsosF4ECGXoK2Wa2FhY8aDXmLx2tfVxk4KQtyu8LFKVixAw4KW8EUWLunYeh6eVZZqQTpyqgRK4H9FcFOD7KycDTSCfMpNz7nOCgR7j2R7ZcQM7uR8mTsyKzxHajBBkI0EB9FYHHK6KhzgVlbDQJfpJefCtFHwR36m9NcQ5F9U4GOflneNPUXt7o376yi2cHSMZl6wztjyKhccmzWIoQkJWFLoFZFU23kAVAxjviRPcOAPr5fHPQoa4G9SvbBHTmmpu19jqVQfEtw9fraFsxjG2NR7bWPnETiUnpeW4bEUOPQ6L96rIPUaX8Nf4isFkm1ix4mAHynDpocFfzXyrg9Cu8P0jg8UZrv5QghGGlqto5roCiJoMYNvbKbMmxsDPuoswwOCHjhirDi4gH\n" +
                "WCLElLQAztbnRN2kvKsy6pzEwVElqG3Jk40Kn0fxxuZrIiIEP5urubOaly5WOYyV8nak9Rmfg25WsZzSlFZl0vbRIfO1yhN1x6IqSqG9eMRuILi3cxUrtblqRpUpwP2jw4KtOZGFf1EGiLkOB4yOJpybfLzqlAO5gAZrh7cSP9sDNn9MaYglMKDpyWCaAS0Coa2FlHl5C71x6HVRl7eZBqah6wG9WiEpBvaLKZqLRu4iDQ2n9fgcJT5jZwfbWqZBkXTlW14RqjLE6nfWexrIpZ94IXaBcbvktHXtWNgYkjswqrQXcwKLOMH9uFuUfbv7GbjxuTpxaFmMScI6Mesv9vtgPUGf5eSPvYVxfZ1an4iLH7zMRWCncpXncHfHoTEYNTPmvPepXyGSS2AuzmafhK1vC4ME2oafbUC1si9K3i7w0xIBCWip88PHg463FPWWT6L6rsaWr7lA9UsWX4cAN3iTYGEGxnC3NZJf2FjBZlGLDO2LwSzBIU0EFIBirW2EXDG2l2E7P3GQ2eq60DUKXTutuXjhPQhWM3G1XmgN60WlxxioTlwhKo1noIBPkzy7CCgKhZVKAegtpbxfN1wkbz0tLSxReB3zchH3ynZ2IbPC8TTA7zCVQMNVghnW3qga5KUEMpR3ApKNBzyIiU2PWknaBnZBt9YxixuFsAN6aCopgqlovhlIgFH4hhACBav0Bq7nkGW4Z9CEeC0rqMH0SbLDZXP4ShqK26bNMWg5IkBgkAWikxK25Fqg92Rv5uG0vIJ2PYH6LfzPuIrn9waYbFPN6a0i17rgJXzfVMixxc9CGonPx0Sr50xeeXUCh1fSxBLfTZ6oAcHl73URS43fnB4cP8jjKRiH4NzBSYMGJhaJw8XiWwoO3HD0zr66mmYuLH4iZpt1zkttbRb7YcbJuKY727vvUx7V76i9764g0MB1ZysSaD9pc7tavPibIDaUc8g7GF2BIbHkJfFQ9PpQrPgC2pW4Ha9EFjhVikwJ\n" +
                "nHqAG0v5R6vbvVUFHIRk33CGyWtb0RQLPFvlE5xs9YsX3UiLMvGZWhjtwQR4fRwe6vAxsnFUKmYtC7u4jExoFAf9nATCCiou0R2H1i0UXp82WLXaMJKscGYrX7lmwAAqQsqMRyDhBwDDvsCEKuNMAA2SJfxAAmYEwhSYlP3i6bHKGDb40EOQKjQ9QjbjuKivVGpGxghDkofsF9pYDmpnaM605evLnCixKN7IEDqrwHivqVjMzlnorBJOsTtos5tv0uKfQLaUMVaIBJLBkemSoJCPXY1zfoucKXb91V9NHLoWVCO3kDHyzuWef5F684wsJ5NmVQr4TOj7YjPYHT5OJ3DiH5uYpTQWSlzv4aMHewi61JFk7k83nbLK4EFKBiuoX951xvBkZ69zDSBstAMwVXe9ZcCsLbzByYToLXK9tjEBvnvU7aijRCchI7DBKINHw9kOPUsUHHVSvUaALASeIy5KnEf6ExWiEvRPYtbgYL0OERYHuejYzV2fCWAamPIyBASyIPciiDWrVmm9U7vjVRWf96kpjPc948KN9CBjzR1hV29lHlWcP06BcjBZKaUQb3CvYj4QrZoPQhl3H9yHcoAyJYcWPZfreGi1Q5nNknRp0MnMfQWsIOJsRgfZECVRtsam9XoneggUDtnVpJGMcOHuirfYy0f9Oqh9rMjORN5LZnM1WKaVVyxzYbFyGZ3c2egnEEbkGr9saSYZ1Qt5HRFwIHwoDOxibXGC8EU8Xpgu35qsvcy8Tz4cAlYzFkgGCCwhx0sSCBk39ab6ev4XTE4441e66VASEENAmNo2gyfCPVHjM1VZ8WqNPkNJFLUNOaSgZUgsikQI1bCECKU7TmWYBAbhjnH9TKBPeONRqzjSHN930YOq3bl6C43nZHEbu7Qr0L4ImCubkRq76kWrynpNzuSqoCN7DawY8NclTkrRhw3n80NnhVXhy5L9p63uavunZ6WsTOCeZqPahuFXBWxzERoQn3H99U2osTV7\n" +
                "EyKTouTrwabNtgCQvcyie6MUxDpl8UzSiBj71kphbcChpwBN03EYDNCTe8w6jCs7HDuS5j1arMZXsMkacmHrkAwBcG008W7yjiVSEgYrxtiJs6VaMwXflC9LTrFKIVrzmz1H7XJni8rFs6aJeHbQ7zEq8SlRGY9fmefHZovaBWxxnNaF6rf2OLK92jJDH0SpLDZpHmbxCMcvDVPOVpI0LDSXuGN7k1wyMYBa41YmopQHUf4PbztIAFmSbzibMAX9n9SGccyW9EcXTC636nUi3GzpOcAyUOW1yIVaJMwNb4eVQgwVABgpKWHQgSA4ftFPDTB7fxjkhXDVKOCbR3GRtzD90U9wGjRKawh7UGiZIc72sXavR6OTWDQc7kTKXrZfQyh5WmjZqnoAUyJtgFO7Fm2O7RHy8QQW5nuZv3Ii5RrVySoxVa4S7TkN6bQT1WgcU31Ykiky13zqA8vqvX2ageQtkQoSZ36A4Zj27Xt9HuOJxxMISP8fRGb4hMLia958EeS3MrE4RaTKcXstyxpxEK4DOsvPizJSGmuF85bLDvVRoyZ9A0nYa6obo5l7NNOajE6crZ7QR1Cuz4myeRAJu6qWQ2gIjy47M5nqXlC4X961LnoUKb3OWklzWhiJ6rj5zn3kU95it2W5vLB5czGEl132VRgbqVWIYpesJAbexoupbc94O1zlZfQeFc4IP3Xbc2ajmYMuARK4PZAIrYsOx4LXsU0OuAWZFbrDva13274j9IHxUeMICcxm53RvvEtvIbcCAvkTB5sf4aAIith6ZNcpASkQoDXqycv8XcYDTkh97rSFJjZRMH7DCBeTOM7MBnfipTiyleXsgkmVaYeU8Q1Q7IPXB37nblynzJOGegQ6I8BgFarLtWniMcKnJ4YHzTH27Xs6pnBUTyoZL4zBQIe1ztsNfNTTWlnGX4KnE8w944BWfKgnnBlLiGU6OTgzWK6gujItJuOyuhyey4q4pQ2rgKCaXZstQUJ21LMZ\n" +
                "XJ6N1W6FGFGNOLUoheKEaS26IIacRA7kaTQtWtOS2DtNvX7xg0wq5ARVEsmu28F5RVE91KKsDDwntrmzgMkesLkl2XlXXZOQlSYW27vKnyRN7QQmsWTjwoir8DhFKmKxbkFnn0uYqJWuonk6cCJIqlZa6V18jpczIwCWG9QkMxSia27625sNJiBz9X44c5D1WqSX5NbImBfSU3pxGckOeFPWV8khCzM0luq8MHNSyI63xlBGxnacxeRvDV6FA747Atpsli6BJUCZk70kfRoj1Hr4NCvL2iuC3oDA4MXCV0WouarN4mqWtRCPaaVoxkUL6I53O2BgeAyocQbiTOmV6QJoGwC4AeBNteoXo63hRbM3hWoOYZbfyfbmYVLpJHFskcM4MI7GMXtKXOeRBJ8LHJtbOL0AT1eY61LDNL2cagzESHyKLiFobRSScMhUtZTktfFezurgXE5CSjDZotiDa77eKGrPKjqMFbWG81P7VMuVwRSJgVckZRRJf4URyxiAIQ7Hr7fU2cwai3BXnxXwViUlylayk6eNrzDsytsbg5bALLBvJDk1QLO5CTLrrEsguwi9QhzxwYTzRISEmsrUIAww7aRkCUWia4KOkiTx9M28IcjpPNkMRksbNptfTC5zPvXBS1WfxYCl2a48W7abvFMRjOJTgy9jvziDLuDHG4exonC1Zs0mCuRSG84x5mfg67xaelUjfGiF8e4nHZGQbDKy0X2WTjYrg7Y1SWrZu0oji7SToRTyhbG8oFzUv4Hhk560pPzJjZkGTyJDYOggmwok1GUVvIh0HTwCzCCt62TI4C1Yqma7LWkD7cZwGcq9EDpLhhHEFDoVQb199WuKMstCqH24cyVqiBJaDioLXrIaOgBQzkBSaIhPzGI3tfWifkuyhDnrlQ0STknuUZpsMsI9TFYiDgs5o8Tj7htN4Qu9w7etmDvsWlF7pLvNK7wGRu8AlVjZy3TZEIyWDmKe8jcJtTeDYan3D3KAqKqE\n" +
                "PWmzvoWMq6HTI5voXTwysm4UwkYmYjAxA91lKxTF2W7z2yy1nJLr5M8BEVVDNsYbsuAJO6ieYALlaFEfmqlUSsooH24aNN3maGbDIh6RQQ9iBQPUIEEVhk6vO30IJob62pEMbSjPKMHQUK97cOKkV8A9gf0DDAUvNkasmHW6pxoqO7zbKAVZTxjS5pm2hKKt8AGZxBgqzKTaa1uAoE4l36cNf4tKuCmpub9tHVfYxtSmKgvUfLQ18rUrP6x5EBCB52rL28VjaLLsZ4Dfx2FUSzSM5MCM60sBiOqKNT6psXUe1EANRneu2mzDToayspjz5rbIJVqjLuoGt36z2wwWrrK6LDiNPmEYQJZqvqZJDaQB7MuaPseMEpBJy0181J3r7iQAeQWluXEbD1MfXmce0v8RAAKcM7ipNvwoPZtmGPEQZoslEwt7UwO0GVenMFCkJzjGN6x89JiqgBrLzvZ5ZNCUBvPHeCX4rGKhQzsPeYhL0PUx3MDHIf8WSaPoaAnRAHslUVj2Jpu9ahu4UX8xeluePERKozQZ6E63I26QFkpJNk4mcmZOAMUfOC09IDUHZgw8xqrfVsUy2vxFij4Wz5YCUYOVMFpfMRyJm4kfkNzZ1foM1Q1y38vFD2Yb97RI7i3TAFl1VBtZkZes069tBYp1n5yaongYBWA3c9v0t7UDEiM3sQpBNIeWPUvhlSyKI1LbE8wQveWz92pfySb04ebn2ljRDbbRkAgHjjA57icr73VhLRSQbuIGoQujOqXgBhfoBomwtorc4MAlW1KlxJ7DocGKItCRmVItp61UY6iPFJHNkng7JBcI5mQJPmkvgsMfYK42M0StMsc7kPogY1kiQ7RmKec50xU9zb8FYGOesu7X5WiGAxMjFqpVoLPZBjXe2age4Xfrao4VDDPlqnieXRaKPnhosBZJXOHQKOueLp6gobMYKnsUj9xJANTz4R2Gnurzia1y6ImUbQ7Qj3MxyAuUwngYPNNMy4ws\n" +
                "x19xo28mwVfwLGGyfputNly8fZGYKne8GyJ3Wr6mTnMyKaw5x7gi0u6VxyixX5VExSIgE1v1UaGgfQJ62DeRm6VKx7DsZiyk3EauYqiKfBR7nvlkxyOQ1ErQXURvJ21o3guPlx9ceDPZy93eUWsukAgqs2WJhYrQ1nHxnn38yTCPD6qVnLtI9PDNekoOvlKclFmHLn8M3TynmiCqGGQFh5H9P5xl3QJxeIWYmq5sV2FRwsMEMPWYyboWSvR23H7Y94AbenAVjSGMfnQRmySy7crYa4lsiJCgoWUY5Xk04tt5FxiVDPmFywUTFIYnfsnDIyyyPkwOkN1l4c1a0laIigQMzPwzYbQxJtCWgI7I7lcAPEe3CjL4lN2iKyNp7ysC1WkjPGj0XwurT1P72bANDJ973pUD0QYRRHQQP6ZkonZAp8WUBZq9ESqR9M8ygrWDEyPiLVYYQsuk4XWJGqt5bEOW3lB8oKH7JY5MwCcSlGzZza4au7obhCuEHnLvSqcUmxYRO2xe2a8ysTjoQBsS22lWSK1iuEi1LrySguYVe21ILZoc4vhtO3qv16SFBthCn61XHy8c07i7UWGpJ8DGrPtNE97j2Sc9RCfCNBHq15Qy5GMy1R3RaQbvLEmClROuH3SceTXiaKGGeztjq63fNERoKXEg48aYvUQunG3R6eNFcB79GqYSFasv3GnshLxAgmfllScw2WSg0yTRQPsaW22hWkK0YSHNegjHrUNfZcTZb5YoYcyZ7OzQiO65zcqHe9JoZEuiivgqO07oO3mhX6Wpq8Iiftcjtq2qVEGmZ9iIGhsSvNW0Bjfh1wZjocIzJIpSa4pADA38ZnkfqkC8wvE1qMq33Xc9WC9ahoeFlCOrhiCNG714kaq3TZsPQxkDGNBFapBLkPvv8XNJxzoiIceeaHKvYIRiYLDgwaOeANjPPBl3l39W3HvZ8qU1fwlg6vHPLIvYNhCwxaELZqnUODcSj9LripRJUNkDyjXz";

        //Act
        String id = urlHashService.hash(basicUrl);

        //Assert
        Assert.assertNotNull(id);
        Assert.assertNotEquals(id,"");
    }

    @Test
    public void hashOnUrlWithFirstChar1NumberOfTimes() throws Exception {
        //Arrange
        String basicUrl = "http://www.cnn.com";
        //Act
        String id = urlHashService.hashOnUrlWithFirstChar(basicUrl,1);

        //Assert
        Assert.assertNotNull(id);
        Assert.assertNotEquals(id,"");
        Assert.assertEquals(id,"6e68e5d7");
    }

    @Test
    public void hashOnUrlWithTheFirstChar10NumberOfTimes() throws Exception {
        //Arrange
        String basicUrl = "http://www.cnn.com";
        //Act
        String id = urlHashService.hashOnUrlWithFirstChar(basicUrl,10);

        //Assert
        Assert.assertNotNull(id);
        Assert.assertNotEquals(id,"");
        Assert.assertEquals(id,"49fd1e96");
    }

    @Test
    public void hashOnUrlWithTheFirstCharPersistence() throws Exception {
        //Arrange
        String basicUrl1 = "http://www.cnn.com";
        String basicUrl2 = "http://www.cnn.com";
        //Act
        String id1 = urlHashService.hashOnUrlWithFirstChar(basicUrl1,1);
        String id2 = urlHashService.hashOnUrlWithFirstChar(basicUrl2,1);

        //Assert
        Assert.assertNotNull(id1);
        Assert.assertNotNull(id2);
        Assert.assertNotEquals(id1,"");
        Assert.assertNotEquals(id2,"");
        Assert.assertEquals(id1,id2);
    }

}