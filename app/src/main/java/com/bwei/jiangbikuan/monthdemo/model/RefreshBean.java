package com.bwei.jiangbikuan.monthdemo.model;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RefreshBean {

    private String stat;
    private List<DataBean> data;

    public static RefreshBean objectFromData(String str) {

        return new Gson().fromJson(str, RefreshBean.class);
    }

    public static RefreshBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), RefreshBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * brief : ​德国媒体《Sportbuzzer》的最新消息，莱万经纪人扎哈维透露其今夏铁心离队，并将自己的想法通报给了拜仁
         * customtag : []
         * daoPaiKey :
         * date : 2018-05-30 10:26
         * hotnews : 0
         * isnxw : 0
         * isrecom : 0
         * isvideo : 0
         * kw : []
         * lbimg : [{"alt":"","describe":"","idx":1,"imgheight":275,"imgname":"20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpl_05500201.jpg","imgwidth":550,"src":"http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpl_05500201.jpg"}]
         * miniimg : [{"alt":"","describe":"","idx":1,"imgheight":240,"imgname":"20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03200403.jpg","imgwidth":320,"src":"http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03200403.jpg"},{"alt":"","describe":"","idx":2,"imgheight":240,"imgname":"20180530102655_7e33f019f7f30ac59bd907e9d8e87984_1_mwpm_03200403.jpg","imgwidth":320,"src":"http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_1_mwpm_03200403.jpg"}]
         * miniimg02 : [{"alt":"","describe":"","idx":1,"imgheight":180,"imgname":"20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03201609.jpg","imgwidth":320,"src":"http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03201609.jpg"},{"alt":"","describe":"","idx":2,"imgheight":180,"imgname":"20180530102655_7e33f019f7f30ac59bd907e9d8e87984_1_mwpm_03201609.jpg","imgwidth":320,"src":"http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_1_mwpm_03201609.jpg"}]
         * miniimg_size : 2
         * pkey : []
         * recommendtype : -1
         * rowkey : 9223370509207560354
         * source : 红色英超
         * tag : []
         * topic : 拜仁锋霸铁心离队，让经纪人施压；曼联今夏第一签倒计时
         * type : tiyu
         * url : 180530102655453.html
         * urlpv : 0
         */

        private String brief;
        private String daoPaiKey;
        private String date;
        private String hotnews;
        private String isnxw;
        private String isrecom;
        private String isvideo;
        private String miniimg_size;
        private String recommendtype;
        private String rowkey;
        private String source;
        private String topic;
        private String type;
        private String url;
        private String urlpv;
        private List<?> customtag;
        private List<?> kw;
        private List<LbimgBean> lbimg;
        private List<MiniimgBean> miniimg;
        private List<Miniimg02Bean> miniimg02;
        private List<?> pkey;
        private List<?> tag;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDaoPaiKey() {
            return daoPaiKey;
        }

        public void setDaoPaiKey(String daoPaiKey) {
            this.daoPaiKey = daoPaiKey;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHotnews() {
            return hotnews;
        }

        public void setHotnews(String hotnews) {
            this.hotnews = hotnews;
        }

        public String getIsnxw() {
            return isnxw;
        }

        public void setIsnxw(String isnxw) {
            this.isnxw = isnxw;
        }

        public String getIsrecom() {
            return isrecom;
        }

        public void setIsrecom(String isrecom) {
            this.isrecom = isrecom;
        }

        public String getIsvideo() {
            return isvideo;
        }

        public void setIsvideo(String isvideo) {
            this.isvideo = isvideo;
        }

        public String getMiniimg_size() {
            return miniimg_size;
        }

        public void setMiniimg_size(String miniimg_size) {
            this.miniimg_size = miniimg_size;
        }

        public String getRecommendtype() {
            return recommendtype;
        }

        public void setRecommendtype(String recommendtype) {
            this.recommendtype = recommendtype;
        }

        public String getRowkey() {
            return rowkey;
        }

        public void setRowkey(String rowkey) {
            this.rowkey = rowkey;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlpv() {
            return urlpv;
        }

        public void setUrlpv(String urlpv) {
            this.urlpv = urlpv;
        }

        public List<?> getCustomtag() {
            return customtag;
        }

        public void setCustomtag(List<?> customtag) {
            this.customtag = customtag;
        }

        public List<?> getKw() {
            return kw;
        }

        public void setKw(List<?> kw) {
            this.kw = kw;
        }

        public List<LbimgBean> getLbimg() {
            return lbimg;
        }

        public void setLbimg(List<LbimgBean> lbimg) {
            this.lbimg = lbimg;
        }

        public List<MiniimgBean> getMiniimg() {
            return miniimg;
        }

        public void setMiniimg(List<MiniimgBean> miniimg) {
            this.miniimg = miniimg;
        }

        public List<Miniimg02Bean> getMiniimg02() {
            return miniimg02;
        }

        public void setMiniimg02(List<Miniimg02Bean> miniimg02) {
            this.miniimg02 = miniimg02;
        }

        public List<?> getPkey() {
            return pkey;
        }

        public void setPkey(List<?> pkey) {
            this.pkey = pkey;
        }

        public List<?> getTag() {
            return tag;
        }

        public void setTag(List<?> tag) {
            this.tag = tag;
        }

        public static class LbimgBean {
            /**
             * alt :
             * describe :
             * idx : 1
             * imgheight : 275
             * imgname : 20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpl_05500201.jpg
             * imgwidth : 550
             * src : http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpl_05500201.jpg
             */

            private String alt;
            private String describe;
            private int idx;
            private int imgheight;
            private String imgname;
            private int imgwidth;
            private String src;

            public static LbimgBean objectFromData(String str) {

                return new Gson().fromJson(str, LbimgBean.class);
            }

            public static LbimgBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), LbimgBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public int getImgheight() {
                return imgheight;
            }

            public void setImgheight(int imgheight) {
                this.imgheight = imgheight;
            }

            public String getImgname() {
                return imgname;
            }

            public void setImgname(String imgname) {
                this.imgname = imgname;
            }

            public int getImgwidth() {
                return imgwidth;
            }

            public void setImgwidth(int imgwidth) {
                this.imgwidth = imgwidth;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }
        }

        public static class MiniimgBean {
            /**
             * alt :
             * describe :
             * idx : 1
             * imgheight : 240
             * imgname : 20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03200403.jpg
             * imgwidth : 320
             * src : http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03200403.jpg
             */

            private String alt;
            private String describe;
            private int idx;
            private int imgheight;
            private String imgname;
            private int imgwidth;
            private String src;

            public static MiniimgBean objectFromData(String str) {

                return new Gson().fromJson(str, MiniimgBean.class);
            }

            public static MiniimgBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), MiniimgBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public int getImgheight() {
                return imgheight;
            }

            public void setImgheight(int imgheight) {
                this.imgheight = imgheight;
            }

            public String getImgname() {
                return imgname;
            }

            public void setImgname(String imgname) {
                this.imgname = imgname;
            }

            public int getImgwidth() {
                return imgwidth;
            }

            public void setImgwidth(int imgwidth) {
                this.imgwidth = imgwidth;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }
        }

        public static class Miniimg02Bean {
            /**
             * alt :
             * describe :
             * idx : 1
             * imgheight : 180
             * imgname : 20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03201609.jpg
             * imgwidth : 320
             * src : http://00.imgmini.eastday.com/mobile/20180530/20180530102655_7e33f019f7f30ac59bd907e9d8e87984_2_mwpm_03201609.jpg
             */

            private String alt;
            private String describe;
            private int idx;
            private int imgheight;
            private String imgname;
            private int imgwidth;
            private String src;

            public static Miniimg02Bean objectFromData(String str) {

                return new Gson().fromJson(str, Miniimg02Bean.class);
            }

            public static Miniimg02Bean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), Miniimg02Bean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public int getImgheight() {
                return imgheight;
            }

            public void setImgheight(int imgheight) {
                this.imgheight = imgheight;
            }

            public String getImgname() {
                return imgname;
            }

            public void setImgname(String imgname) {
                this.imgname = imgname;
            }

            public int getImgwidth() {
                return imgwidth;
            }

            public void setImgwidth(int imgwidth) {
                this.imgwidth = imgwidth;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }
        }
    }
}
