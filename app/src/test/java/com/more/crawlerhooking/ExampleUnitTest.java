package com.more.crawlerhooking;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.http.beans.tiktok.aweme.AwemeStructV2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
assertEquals(4, 2 + 2);
    }

    @Test
    public void testBytes2String(){
        File file = new File("/Users/motao/Documents/code/MyNote/Crawler/Tiktok/bytes.txt");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                builder.append(line);
            }
            String[] strings = builder.toString().split(",");
            byte[] bys = new byte[strings.length];
            for (int i=0; i < strings.length; i++){
                bys[i] = (byte) Integer.parseInt(strings[i]);
            }
            String res = new String(bys, StandardCharsets.UTF_8);
            System.out.println("Bytes2String: " + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRandomUdid(){
        String androidId = new BigInteger(80, new SecureRandom()).toString(16);
        if (androidId.charAt(0) == 45){
            androidId = androidId.substring(1);
        }
        int len = 13 - androidId.length();
        if (len > 0){
            StringBuilder builder = new StringBuilder();
            while (len > 0){
                builder.append("F");
                len--;
            }
            builder.append(androidId);
            androidId = builder.toString();
        }
        System.out.println(androidId);
    }

    @Test
    public void testAwemeJson(){
        String awemeJson = "{\n" +
                "    \"allow_gift\": true,\n" +
                "    \"anchors\": [],\n" +
                "    \"anchors_extras\": \"\",\n" +
                "    \"author\": {\n" +
                "        \"ad_cover_url\": [],\n" +
                "        \"authority_status\": 0,\n" +
                "        \"avatar_168x168\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_168x168.webp?x-expires=1641448800&x-signature=1IUU2HTIskAYn9gJHVQh9vRfRd4%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_168x168.jpeg?x-expires=1641448800&x-signature=w4pZl6ksw%2Fd1Dt5etdY4yyekV5w%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"avatar_300x300\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_300x300.webp?x-expires=1641448800&x-signature=i3L2SFIKMubzveqHwt3bYUZz4FM%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_300x300.jpeg?x-expires=1641448800&x-signature=D7YFw%2FtFn89l%2BoYytEzUFl6u2i4%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"avatar_medium\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.webp?x-expires=1641448800&x-signature=%2Bx5eNBfduVFh6soBcomjU1SnccU%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.jpeg?x-expires=1641448800&x-signature=LeXf0J3iILFx7JrLrcJxuT3uzwo%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"avatar_thumb\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.webp?x-expires=1641448800&x-signature=dWRCdGMA9f4RsaB%2BjLyRaKgwDSE%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.jpeg?x-expires=1641448800&x-signature=TV9hVUkovYkIuXb9zIlflkNozrs%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"cha_list\": [],\n" +
                "        \"comment_filter_status\": 0,\n" +
                "        \"comment_setting\": 0,\n" +
                "        \"commerce_user_level\": 0,\n" +
                "        \"cover_url\": [{\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tiktok-obj/1613727517271041\",\n" +
                "            \"url_list\": [\"https://p16-sg.tiktokcdn.com/obj/tiktok-obj/1613727517271041\"],\n" +
                "            \"width\": 720\n" +
                "        }],\n" +
                "        \"custom_verify\": \"\",\n" +
                "        \"download_setting\": 0,\n" +
                "        \"duet_setting\": 0,\n" +
                "        \"follow_status\": 0,\n" +
                "        \"follower_status\": 0,\n" +
                "        \"followers_detail\": [],\n" +
                "        \"is_ad_fake\": false,\n" +
                "        \"is_block\": false,\n" +
                "        \"is_discipline_member\": false,\n" +
                "        \"is_star\": false,\n" +
                "        \"item_list\": [],\n" +
                "        \"language\": \"en\",\n" +
                "        \"nickname\": \"Beautiful earth \uD83C\uDF0D\",\n" +
                "        \"platform_sync_info\": [],\n" +
                "        \"prevent_download\": false,\n" +
                "        \"region\": \"US\",\n" +
                "        \"relative_users\": [],\n" +
                "        \"room_id\": 0,\n" +
                "        \"sec_uid\": \"MS4wLjABAAAAKPzCmXcAuIN2YPy4zrld3H2CSI4HZDU9Pa3fMP85Rya5U8NjktFu9NPJWaOP_4MZ\",\n" +
                "        \"secret\": 0,\n" +
                "        \"share_info\": {\n" +
                "            \"share_desc\": \"\",\n" +
                "            \"share_desc_info\": \"\",\n" +
                "            \"share_qrcode_url\": {\n" +
                "                \"height\": 720,\n" +
                "                \"uri\": \"\",\n" +
                "                \"url_list\": [],\n" +
                "                \"width\": 720\n" +
                "            },\n" +
                "            \"share_title\": \"\",\n" +
                "            \"share_title_myself\": \"\",\n" +
                "            \"share_title_other\": \"\",\n" +
                "            \"share_url\": \"\"\n" +
                "        },\n" +
                "        \"short_id\": \"0\",\n" +
                "        \"signature\": \"\uD83C\uDFB6Thank you for your attention\uD83C\uDFB6\\n\uD83E\uDD70Enjoy the beauty of nature with you\uD83E\uDD70\",\n" +
                "        \"type_label\": [],\n" +
                "        \"uid\": \"6938933427820430341\",\n" +
                "        \"unique_id\": \"zyb231024\",\n" +
                "        \"verification_type\": 1,\n" +
                "        \"verify_info\": \"\",\n" +
                "        \"video_icon\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"\",\n" +
                "            \"url_list\": [],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"with_commerce_entry\": false\n" +
                "    },\n" +
                "    \"aweme_acl\": {\n" +
                "        \"download_general\": {},\n" +
                "        \"download_mask_panel\": {},\n" +
                "        \"platform_list\": [],\n" +
                "        \"share_general\": {},\n" +
                "        \"share_list_status\": 0\n" +
                "    },\n" +
                "    \"aweme_id\": \"7041789688750968111\",\n" +
                "    \"aweme_type\": 0,\n" +
                "    \"bodydance_score\": 0,\n" +
                "    \"cha_list\": [{\n" +
                "        \"author\": {\n" +
                "            \"ad_cover_url\": [],\n" +
                "            \"cha_list\": [],\n" +
                "            \"cover_url\": [],\n" +
                "            \"followers_detail\": [],\n" +
                "            \"item_list\": [],\n" +
                "            \"platform_sync_info\": [],\n" +
                "            \"relative_users\": [],\n" +
                "            \"type_label\": []\n" +
                "        },\n" +
                "        \"cha_attrs\": [],\n" +
                "        \"cha_name\": \"scenery\",\n" +
                "        \"cid\": \"29533\",\n" +
                "        \"collect_stat\": 0,\n" +
                "        \"connect_music\": [],\n" +
                "        \"desc\": \"\",\n" +
                "        \"is_challenge\": 0,\n" +
                "        \"is_commerce\": false,\n" +
                "        \"is_pgcshow\": false,\n" +
                "        \"schema\": \"aweme://aweme/challenge/detail?cid=29533\",\n" +
                "        \"share_info\": {\n" +
                "            \"bool_persist\": 0,\n" +
                "            \"share_desc\": \"Check out #scenery on TikTok!\",\n" +
                "            \"share_desc_info\": \"Check out #scenery on TikTok!\",\n" +
                "            \"share_quote\": \"\",\n" +
                "            \"share_signature_desc\": \"\",\n" +
                "            \"share_signature_url\": \"\",\n" +
                "            \"share_title\": \"It is a becoming a big trend on TikTok now! Click here: scenery\",\n" +
                "            \"share_title_myself\": \"\",\n" +
                "            \"share_title_other\": \"\",\n" +
                "            \"share_url\": \"https://m.tiktok.com/h5/share/tag/29533.html?name=scenery&u_code=dk9548a7kcaf26&language=fr&_d=dlmke57320dfch&share_challenge_id=29533&source=h5_m\"\n" +
                "        },\n" +
                "        \"sub_type\": 0,\n" +
                "        \"type\": 1,\n" +
                "        \"user_count\": 0,\n" +
                "        \"view_count\": 0\n" +
                "    }],\n" +
                "    \"cmt_swt\": false,\n" +
                "    \"collect_stat\": 0,\n" +
                "    \"commerce_config_data\": [],\n" +
                "    \"commerce_info\": {\"with_comment_filter_words\": false},\n" +
                "    \"create_time\": 1639544427,\n" +
                "    \"desc\": \"#scenery\",\n" +
                "    \"desc_language\": \"un\",\n" +
                "    \"distance\": \"\",\n" +
                "    \"distribute_type\": 1,\n" +
                "    \"geofencing_regions\": [],\n" +
                "    \"group_id\": \"7041789688750968111\",\n" +
                "    \"has_vs_entry\": false,\n" +
                "    \"hybrid_label\": [],\n" +
                "    \"image_infos\": [],\n" +
                "    \"interaction_stickers\": [],\n" +
                "    \"is_ads\": false,\n" +
                "    \"is_hash_tag\": 1,\n" +
                "    \"is_pgcshow\": false,\n" +
                "    \"is_relieve\": false,\n" +
                "    \"is_top\": 0,\n" +
                "    \"is_vr\": false,\n" +
                "    \"item_comment_settings\": 0,\n" +
                "    \"item_duet\": 0,\n" +
                "    \"item_react\": 0,\n" +
                "    \"item_stitch\": 0,\n" +
                "    \"label_top\": {\n" +
                "        \"height\": 720,\n" +
                "        \"uri\": \"tiktok-obj/1598708589477025.PNG\",\n" +
                "        \"url_list\": [\"https://p16-sg.tiktokcdn.com/obj/tiktok-obj/1598708589477025.PNG\"],\n" +
                "        \"width\": 720\n" +
                "    },\n" +
                "    \"label_top_text\": [],\n" +
                "    \"long_video\": [],\n" +
                "    \"mask_infos\": [],\n" +
                "    \"misc_info\": \"{}\",\n" +
                "    \"music\": {\n" +
                "        \"album\": \"\",\n" +
                "        \"author\": \"Beautiful earth \uD83C\uDF0D\",\n" +
                "        \"author_deleted\": false,\n" +
                "        \"author_position\": [],\n" +
                "        \"avatar_medium\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.webp?x-expires=1641448800&x-signature=%2Bx5eNBfduVFh6soBcomjU1SnccU%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.jpeg?x-expires=1641448800&x-signature=LeXf0J3iILFx7JrLrcJxuT3uzwo%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"avatar_thumb\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.webp?x-expires=1641448800&x-signature=dWRCdGMA9f4RsaB%2BjLyRaKgwDSE%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.jpeg?x-expires=1641448800&x-signature=TV9hVUkovYkIuXb9zIlflkNozrs%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"binded_challenge_id\": 0,\n" +
                "        \"collect_stat\": 0,\n" +
                "        \"cover_large\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_1080x1080.webp?x-expires=1641448800&x-signature=7SkhIfZLKEnSFIGn5k4oJXaCEhA%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_1080x1080.jpeg?x-expires=1641448800&x-signature=lnrSKsV7vNn1Cl573Iun7Ob2JkA%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"cover_medium\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.webp?x-expires=1641448800&x-signature=%2Bx5eNBfduVFh6soBcomjU1SnccU%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.jpeg?x-expires=1641448800&x-signature=LeXf0J3iILFx7JrLrcJxuT3uzwo%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"cover_thumb\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.webp?x-expires=1641448800&x-signature=dWRCdGMA9f4RsaB%2BjLyRaKgwDSE%3D\",\n" +
                "                \"https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.jpeg?x-expires=1641448800&x-signature=TV9hVUkovYkIuXb9zIlflkNozrs%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"duration\": 6,\n" +
                "        \"external_song_info\": [],\n" +
                "        \"extra\": \"{\\\"beats\\\":{},\\\"schedule_search_time\\\":0,\\\"aed_music_dur\\\":6.27,\\\"is_ugc_mapping\\\":true,\\\"has_edited\\\":0,\\\"reviewed\\\":0,\\\"review_unshelve_reason\\\":0}\",\n" +
                "        \"id\": 7041789626905987887,\n" +
                "        \"id_str\": \"7041789626905987887\",\n" +
                "        \"is_author_artist\": false,\n" +
                "        \"is_commerce_music\": true,\n" +
                "        \"is_original\": false,\n" +
                "        \"is_pgc\": false,\n" +
                "        \"matched_pgc_sound\": {\n" +
                "            \"author\": \"찬열 (CHANYEOL) & 펀치 (Punch)\",\n" +
                "            \"mixed_author\": \"Contains music from: \\\"Stay With Me\\\"\",\n" +
                "            \"mixed_title\": \"original sound - zyb231024 (Contains music from: Stay With Me - 찬열 (CHANYEOL) & 펀치 (Punch))\",\n" +
                "            \"title\": \"Stay With Me\"\n" +
                "        },\n" +
                "        \"matched_song\": {\n" +
                "            \"author\": \"찬열 (CHANYEOL) & 펀치 (Punch)\",\n" +
                "            \"cover_medium\": {\n" +
                "                \"height\": 720,\n" +
                "                \"uri\": \"tos-alisg-v-2774/9d438739952f4c4e84a542a628545643\",\n" +
                "                \"url_list\": [\"https://p16-sg.tiktokcdn.com/aweme/200x200/tos-alisg-v-2774/9d438739952f4c4e84a542a628545643.jpeg\"],\n" +
                "                \"width\": 720\n" +
                "            },\n" +
                "            \"h5_url\": \"\",\n" +
                "            \"id\": \"6913678135750592513\",\n" +
                "            \"title\": \"Stay With Me\"\n" +
                "        },\n" +
                "        \"mute_share\": false,\n" +
                "        \"offline_desc\": \"\",\n" +
                "        \"owner_handle\": \"zyb231024\",\n" +
                "        \"owner_id\": \"6938933427820430341\",\n" +
                "        \"owner_nickname\": \"Beautiful earth \uD83C\uDF0D\",\n" +
                "        \"play_url\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"https://sf16-ies-music-va.tiktokcdn.com/obj/ies-music-ttp-dup-us/7041789657415437102.mp3\",\n" +
                "            \"url_list\": [\"https://sf16-ies-music-va.tiktokcdn.com/obj/ies-music-ttp-dup-us/7041789657415437102.mp3\"],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"position\": [],\n" +
                "        \"prevent_download\": false,\n" +
                "        \"preview_end_time\": 0,\n" +
                "        \"preview_start_time\": 0,\n" +
                "        \"sec_uid\": \"MS4wLjABAAAAKPzCmXcAuIN2YPy4zrld3H2CSI4HZDU9Pa3fMP85Rya5U8NjktFu9NPJWaOP_4MZ\",\n" +
                "        \"source_platform\": 72,\n" +
                "        \"status\": 1,\n" +
                "        \"strong_beat_url\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"https://sf16-ies-music-sg.tiktokcdn.com/obj/tiktok-obj/pattern/0744c94f8f7286b75fc411e696b2b5c1.json\",\n" +
                "            \"url_list\": [\"https://sf16-ies-music-sg.tiktokcdn.com/obj/tiktok-obj/pattern/0744c94f8f7286b75fc411e696b2b5c1.json\"],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"title\": \"original sound - zyb231024\",\n" +
                "        \"user_count\": 0\n" +
                "    },\n" +
                "    \"need_vs_entry\": false,\n" +
                "    \"nickname_position\": [],\n" +
                "    \"origin_comment_ids\": [],\n" +
                "    \"position\": [],\n" +
                "    \"preload\": {},\n" +
                "    \"prevent_download\": false,\n" +
                "    \"rate\": 12,\n" +
                "    \"region\": \"US\",\n" +
                "    \"risk_infos\": {\n" +
                "        \"content\": \"\",\n" +
                "        \"risk_sink\": false,\n" +
                "        \"type\": 0,\n" +
                "        \"vote\": false,\n" +
                "        \"warn\": false\n" +
                "    },\n" +
                "    \"share_info\": {\n" +
                "        \"bool_persist\": 0,\n" +
                "        \"share_desc\": \"Check out Beautiful earth \uD83C\uDF0D's video! #TikTok\",\n" +
                "        \"share_desc_info\": \"TikTok: Make Every Second CountCheck out Beautiful earth \uD83C\uDF0D\\u2019s video! #TikTok > \",\n" +
                "        \"share_link_desc\": \"\",\n" +
                "        \"share_quote\": \"\",\n" +
                "        \"share_signature_desc\": \"\",\n" +
                "        \"share_signature_url\": \"\",\n" +
                "        \"share_title\": \"Check out Beautiful earth \uD83C\uDF0D\\u2019s video! #TikTok > \",\n" +
                "        \"share_title_myself\": \"\",\n" +
                "        \"share_title_other\": \"\",\n" +
                "        \"share_url\": \"https://m.tiktok.com/v/7041789688750968111.html?u_code=dk9548a7kcaf26&preview_pb=0&language=fr&_d=dlmke57320dfch&share_item_id=7041789688750968111&source=h5_m\",\n" +
                "        \"whatsapp_desc\": \"Download TikTok and watch more fun videos:\"\n" +
                "    },\n" +
                "    \"share_url\": \"https://m.tiktok.com/v/7041789688750968111.html?u_code=dk9548a7kcaf26&preview_pb=0&language=fr&_d=dlmke57320dfch&share_item_id=7041789688750968111&source=h5_m\",\n" +
                "    \"sort_label\": \"_\",\n" +
                "    \"statistics\": {\n" +
                "        \"aweme_id\": \"7041789688750968111\",\n" +
                "        \"comment_count\": 232,\n" +
                "        \"digg_count\": 40773,\n" +
                "        \"download_count\": 8043,\n" +
                "        \"forward_count\": 0,\n" +
                "        \"lose_comment_count\": 0,\n" +
                "        \"lose_count\": 0,\n" +
                "        \"play_count\": 528206,\n" +
                "        \"share_count\": 4586,\n" +
                "        \"whatsapp_share_count\": 902\n" +
                "    },\n" +
                "    \"status\": {\n" +
                "        \"allow_comment\": true,\n" +
                "        \"allow_share\": true,\n" +
                "        \"aweme_id\": \"7041789688750968111\",\n" +
                "        \"download_status\": 0,\n" +
                "        \"in_reviewing\": false,\n" +
                "        \"is_delete\": false,\n" +
                "        \"is_prohibited\": false,\n" +
                "        \"private_status\": 0,\n" +
                "        \"reviewed\": 1,\n" +
                "        \"self_see\": false\n" +
                "    },\n" +
                "    \"text_extra\": [{\n" +
                "        \"end\": 8,\n" +
                "        \"hashtag_id\": \"29533\",\n" +
                "        \"hashtag_name\": \"scenery\",\n" +
                "        \"is_commerce\": false,\n" +
                "        \"start\": 0,\n" +
                "        \"type\": 1\n" +
                "    }],\n" +
                "    \"uniqid_position\": [],\n" +
                "    \"user_digged\": 0,\n" +
                "    \"video\": {\n" +
                "        \"big_thumbs\": [],\n" +
                "        \"bit_rate\": [\n" +
                "            {\n" +
                "                \"bit_rate\": 1673566,\n" +
                "                \"gear_name\": \"adapt_lower_720_1\",\n" +
                "                \"is_bytevc1\": 1,\n" +
                "                \"play_addr\": {\n" +
                "                    \"data_size\": 1345129,\n" +
                "                    \"file_cs\": \"c:0-5296-0c97\",\n" +
                "                    \"file_hash\": \"6c8f540d1eec0eb6054d4f50daab1f4d\",\n" +
                "                    \"height\": 1280,\n" +
                "                    \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "                    \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_bytevc1_720p_1673566\",\n" +
                "                    \"url_list\": [\n" +
                "                        \"https://v39-as.tiktokcdn.com/c7982af697fad3652f2619d80caf4ca1/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c003-tx/4b51a43a3cad4608ac89b8d0805efc56/?a=1180&br=3268&bt=1634&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=3&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=14&rc=anh4a2Y6ZnFxOTMzZzczNEApZTRmaWY0NWRoN2k8Ojk4ZGdxbm9zcjQwYHBgLS1kMS9zczMuMV5gYC4uLl9eXjAvNl46Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://v16.tiktokcdn.com/e9ea6d2160437a423aa413a68ad18f0d/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c003-tx/4b51a43a3cad4608ac89b8d0805efc56/?a=1180&br=3268&bt=1634&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=3&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=14&rc=anh4a2Y6ZnFxOTMzZzczNEApZTRmaWY0NWRoN2k8Ojk4ZGdxbm9zcjQwYHBgLS1kMS9zczMuMV5gYC4uLl9eXjAvNl46Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=aa5962739afa4be1a1211cccfac411b6\"\n" +
                "                    ],\n" +
                "                    \"width\": 720\n" +
                "                },\n" +
                "                \"quality_type\": 14\n" +
                "            },\n" +
                "            {\n" +
                "                \"bit_rate\": 1355762,\n" +
                "                \"gear_name\": \"adapt_540_1\",\n" +
                "                \"is_bytevc1\": 1,\n" +
                "                \"play_addr\": {\n" +
                "                    \"data_size\": 1089694,\n" +
                "                    \"file_cs\": \"c:0-5296-528d\",\n" +
                "                    \"file_hash\": \"a90dc48cd6519908f5b469c22ecc56d1\",\n" +
                "                    \"height\": 1024,\n" +
                "                    \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "                    \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_bytevc1_540p_1355762\",\n" +
                "                    \"url_list\": [\n" +
                "                        \"https://v39-as.tiktokcdn.com/b8ba98da767606ed0d1983e5cc6d7333/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/664756a61cd5417fa352794c6e3ccc54/?a=1180&br=2646&bt=1323&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=11&rc=anh4a2Y6ZnFxOTMzZzczNEApZzNlNzY6aGRnNzU8ZGgzM2dxbm9zcjQwYHBgLS1kMS9zc15fNWIvXjNeM2M1NDY2LzU6Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://v16.tiktokcdn.com/9c4b2242e997b5e3a2d3d19dd74de973/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/664756a61cd5417fa352794c6e3ccc54/?a=1180&br=2646&bt=1323&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=11&rc=anh4a2Y6ZnFxOTMzZzczNEApZzNlNzY6aGRnNzU8ZGgzM2dxbm9zcjQwYHBgLS1kMS9zc15fNWIvXjNeM2M1NDY2LzU6Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=0802e9a997284fd6aae67a324eb80bda\"\n" +
                "                    ],\n" +
                "                    \"width\": 576\n" +
                "                },\n" +
                "                \"quality_type\": 28\n" +
                "            },\n" +
                "            {\n" +
                "                \"bit_rate\": 724074,\n" +
                "                \"gear_name\": \"lower_540_1\",\n" +
                "                \"is_bytevc1\": 1,\n" +
                "                \"play_addr\": {\n" +
                "                    \"data_size\": 581975,\n" +
                "                    \"file_cs\": \"c:0-5296-2587\",\n" +
                "                    \"file_hash\": \"70d46f1316dedc4ec254439c539a68ef\",\n" +
                "                    \"height\": 1024,\n" +
                "                    \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "                    \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_bytevc1_540p_724074\",\n" +
                "                    \"url_list\": [\n" +
                "                        \"https://v39-as.tiktokcdn.com/72969aaedff931c02a60e7f60e3a73d8/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c003-tx/3ed4be81df674f8a852df580c647e477/?a=1180&br=1414&bt=707&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=4&rc=anh4a2Y6ZnFxOTMzZzczNEApZWU3OzYzNmQ0NzQ0OGk7Zmdxbm9zcjQwYHBgLS1kMS9zc2MvM2JiYDQvNGMxYDQ2LV86Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://v16.tiktokcdn.com/d235f81baf8a212e673d3872ca37f24a/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c003-tx/3ed4be81df674f8a852df580c647e477/?a=1180&br=1414&bt=707&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=4&rc=anh4a2Y6ZnFxOTMzZzczNEApZWU3OzYzNmQ0NzQ0OGk7Zmdxbm9zcjQwYHBgLS1kMS9zc2MvM2JiYDQvNGMxYDQ2LV86Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=cb80f9571c144f17a2370c3e8e46b2bf\"\n" +
                "                    ],\n" +
                "                    \"width\": 576\n" +
                "                },\n" +
                "                \"quality_type\": 24\n" +
                "            },\n" +
                "            {\n" +
                "                \"bit_rate\": 528167,\n" +
                "                \"gear_name\": \"lowest_540_1\",\n" +
                "                \"is_bytevc1\": 1,\n" +
                "                \"play_addr\": {\n" +
                "                    \"data_size\": 424515,\n" +
                "                    \"file_cs\": \"c:0-5296-0f2f\",\n" +
                "                    \"file_hash\": \"24f4874a37a9dd171b91c49177e65968\",\n" +
                "                    \"height\": 1024,\n" +
                "                    \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "                    \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_bytevc1_540p_528167\",\n" +
                "                    \"url_list\": [\n" +
                "                        \"https://v39-as.tiktokcdn.com/5038f1f6a6550645bdcb7c47bd796f0a/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/fb0a0b40e2174b1bb715e234195608eb/?a=1180&br=1030&bt=515&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=5&rc=anh4a2Y6ZnFxOTMzZzczNEApN2k8aTVnPDtnN2c7NTQzOGdxbm9zcjQwYHBgLS1kMS9zczY2YmA0LS4zLjUuLjFiLS46Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://v16.tiktokcdn.com/b1a3a5030923a1d3e8969cc5a027c76c/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/fb0a0b40e2174b1bb715e234195608eb/?a=1180&br=1030&bt=515&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=5&rc=anh4a2Y6ZnFxOTMzZzczNEApN2k8aTVnPDtnN2c7NTQzOGdxbm9zcjQwYHBgLS1kMS9zczY2YmA0LS4zLjUuLjFiLS46Yw%3D%3D&vl=&vr=\",\n" +
                "                        \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=51001e2481d148d18691d027fc9ef949\"\n" +
                "                    ],\n" +
                "                    \"width\": 576\n" +
                "                },\n" +
                "                \"quality_type\": 25\n" +
                "            }\n" +
                "        ],\n" +
                "        \"cdn_url_expired\": 0,\n" +
                "        \"cover\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"large/tos-useast5-p-0068-tx/6f54ded73be24660a17b7736d8312eb1\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign.tiktokcdn-us.com/large/tos-useast5-p-0068-tx/6f54ded73be24660a17b7736d8312eb1.webp?x-expires=1641384000&x-signature=%2FRjGz8BexkhbM7p9f%2FNYY8M5gT0%3D\",\n" +
                "                \"https://p19-sign.tiktokcdn-us.com/large/tos-useast5-p-0068-tx/6f54ded73be24660a17b7736d8312eb1.webp?x-expires=1641384000&x-signature=8tZaBNdP2ST0QPJGzku0%2Bb5EMxk%3D\",\n" +
                "                \"https://p16-sign.tiktokcdn-us.com/large/tos-useast5-p-0068-tx/6f54ded73be24660a17b7736d8312eb1.jpeg?x-expires=1641384000&x-signature=DSETShJTj4LdCPJIuee8UO6QdDQ%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"download_addr\": {\n" +
                "            \"data_size\": 1759667,\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://v39-as.tiktokcdn.com/7c498a4ad8d37bb90eaf611bd75a16b1/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c002-tx/193e4e78c21f4816b4d5418ed8842d39/?a=1180&br=4276&bt=2138&cd=0%7C0%7C0&ch=0&cr=3&cs=0&cv=1&dr=0&ds=3&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=0&rc=anh4a2Y6ZnFxOTMzZzczNEApPDpoOGczaTs8Nzo6Zjg0M2dxbm9zcjQwYHBgLS1kMS9zc2ExLzZjXzYtYC5hYjVeNjI6Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://v16.tiktokcdn.com/12b9f9d8ff7db0f3cead78f5271629ed/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c002-tx/193e4e78c21f4816b4d5418ed8842d39/?a=1180&br=4276&bt=2138&cd=0%7C0%7C0&ch=0&cr=3&cs=0&cv=1&dr=0&ds=3&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=0&rc=anh4a2Y6ZnFxOTMzZzczNEApPDpoOGczaTs8Nzo6Zjg0M2dxbm9zcjQwYHBgLS1kMS9zc2ExLzZjXzYtYC5hYjVeNjI6Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&ratio=720p&watermark=1&media_type=4&vr_type=0&improve_bitrate=0&logo_name=tiktok_m&quality_type=11&source=FEED\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"duration\": 6430,\n" +
                "        \"dynamic_cover\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-useast5-p-0068-tx/132789762ecd4420a2fc171603bf36ee_1639544429\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign.tiktokcdn-us.com/obj/tos-useast5-p-0068-tx/132789762ecd4420a2fc171603bf36ee_1639544429?x-expires=1641384000&x-signature=AVnWA4au4xS662aQaYMGGodRqtk%3D\",\n" +
                "                \"https://p19-sign.tiktokcdn-us.com/obj/tos-useast5-p-0068-tx/132789762ecd4420a2fc171603bf36ee_1639544429?x-expires=1641384000&x-signature=NLZH5nLY9%2FPqGi7iRNuycYOb5fI%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"has_watermark\": true,\n" +
                "        \"height\": 1024,\n" +
                "        \"is_bytevc1\": 0,\n" +
                "        \"meta\": \"{\\\"loudness\\\":\\\"-14.1\\\",\\\"peak\\\":\\\"1\\\"}\",\n" +
                "        \"need_set_token\": false,\n" +
                "        \"origin_cover\": {\n" +
                "            \"height\": 720,\n" +
                "            \"uri\": \"tos-useast5-p-0068-tx/25b9c4ba89da4159a400a07fa2a67d63_1639544429\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://p16-sign.tiktokcdn-us.com/tos-useast5-p-0068-tx/25b9c4ba89da4159a400a07fa2a67d63_1639544429~tplv-tiktokx-360p.webp?x-expires=1641384000&x-signature=7x3QDxwRvogICeOebBYxdSIwq4s%3D\",\n" +
                "                \"https://p19-sign.tiktokcdn-us.com/tos-useast5-p-0068-tx/25b9c4ba89da4159a400a07fa2a67d63_1639544429~tplv-tiktokx-360p.webp?x-expires=1641384000&x-signature=LKpU00fSZPo121AZDRIW9k8G78g%3D\",\n" +
                "                \"https://p16-sign.tiktokcdn-us.com/tos-useast5-p-0068-tx/25b9c4ba89da4159a400a07fa2a67d63_1639544429~tplv-tiktokx-360p.jpeg?x-expires=1641384000&x-signature=90k5JFELAJ8ly9HzN8S8Lx8Vq98%3D\"\n" +
                "            ],\n" +
                "            \"width\": 720\n" +
                "        },\n" +
                "        \"play_addr\": {\n" +
                "            \"data_size\": 1778201,\n" +
                "            \"file_cs\": \"c:0-5190-15b7\",\n" +
                "            \"file_hash\": \"9e990fed15d27251d066d0a5377dd1bb\",\n" +
                "            \"height\": 1024,\n" +
                "            \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "            \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_h264_540p_2212380\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://v39-as.tiktokcdn.com/c58877027fd1e38f6ff305d244445f3d/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/7ca2cd5887da4b4b839eb0b6ab827dd3/?a=1180&br=4320&bt=2160&cd=0%7C0%7C0&ch=0&cr=3&cs=0&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=0&rc=anh4a2Y6ZnFxOTMzZzczNEApZzo1PDU8Z2RkNzg1ODZoO2dxbm9zcjQwYHBgLS1kMS9zcy9eXzRiMGBfM2FhNjEwL186Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://v16.tiktokcdn.com/badef4e061278c8b24d25078f3c3be06/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/7ca2cd5887da4b4b839eb0b6ab827dd3/?a=1180&br=4320&bt=2160&cd=0%7C0%7C0&ch=0&cr=3&cs=0&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=0&rc=anh4a2Y6ZnFxOTMzZzczNEApZzo1PDU8Z2RkNzg1ODZoO2dxbm9zcjQwYHBgLS1kMS9zcy9eXzRiMGBfM2FhNjEwL186Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=8be23354295d4da6abdc932e972b7ad2\"\n" +
                "            ],\n" +
                "            \"width\": 576\n" +
                "        },\n" +
                "        \"play_addr_bytevc1\": {\n" +
                "            \"data_size\": 1089694,\n" +
                "            \"file_cs\": \"c:0-5296-528d\",\n" +
                "            \"file_hash\": \"a90dc48cd6519908f5b469c22ecc56d1\",\n" +
                "            \"height\": 1024,\n" +
                "            \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "            \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_bytevc1_540p_1355762\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://v39-as.tiktokcdn.com/b8ba98da767606ed0d1983e5cc6d7333/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/664756a61cd5417fa352794c6e3ccc54/?a=1180&br=2646&bt=1323&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=11&rc=anh4a2Y6ZnFxOTMzZzczNEApZzNlNzY6aGRnNzU8ZGgzM2dxbm9zcjQwYHBgLS1kMS9zc15fNWIvXjNeM2M1NDY2LzU6Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://v16.tiktokcdn.com/9c4b2242e997b5e3a2d3d19dd74de973/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/664756a61cd5417fa352794c6e3ccc54/?a=1180&br=2646&bt=1323&cd=0%7C0%7C0&ch=0&cr=3&cs=2&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=11&rc=anh4a2Y6ZnFxOTMzZzczNEApZzNlNzY6aGRnNzU8ZGgzM2dxbm9zcjQwYHBgLS1kMS9zc15fNWIvXjNeM2M1NDY2LzU6Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=0802e9a997284fd6aae67a324eb80bda\"\n" +
                "            ],\n" +
                "            \"width\": 576\n" +
                "        },\n" +
                "        \"play_addr_h264\": {\n" +
                "            \"data_size\": 1778201,\n" +
                "            \"file_cs\": \"c:0-5190-15b7\",\n" +
                "            \"file_hash\": \"9e990fed15d27251d066d0a5377dd1bb\",\n" +
                "            \"height\": 1024,\n" +
                "            \"uri\": \"v12044gd0000c6sncn3c77ucvhruqutg\",\n" +
                "            \"url_key\": \"v12044gd0000c6sncn3c77ucvhruqutg_h264_540p_2212380\",\n" +
                "            \"url_list\": [\n" +
                "                \"https://v39-as.tiktokcdn.com/c58877027fd1e38f6ff305d244445f3d/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/7ca2cd5887da4b4b839eb0b6ab827dd3/?a=1180&br=4320&bt=2160&cd=0%7C0%7C0&ch=0&cr=3&cs=0&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=0&rc=anh4a2Y6ZnFxOTMzZzczNEApZzo1PDU8Z2RkNzg1ODZoO2dxbm9zcjQwYHBgLS1kMS9zcy9eXzRiMGBfM2FhNjEwL186Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://v16.tiktokcdn.com/badef4e061278c8b24d25078f3c3be06/61d58ef1/video/tos/useast5/tos-useast5-ve-0068c001-tx/7ca2cd5887da4b4b839eb0b6ab827dd3/?a=1180&br=4320&bt=2160&cd=0%7C0%7C0&ch=0&cr=3&cs=0&cv=1&dr=0&ds=6&er=&ft=s12NL3zqnz7Th1i5elXq&l=20220105062826010245040053242A1B5C&lr=all&mime_type=video_mp4&net=0&pl=0&qs=0&rc=anh4a2Y6ZnFxOTMzZzczNEApZzo1PDU8Z2RkNzg1ODZoO2dxbm9zcjQwYHBgLS1kMS9zcy9eXzRiMGBfM2FhNjEwL186Yw%3D%3D&vl=&vr=\",\n" +
                "                \"https://api-h2.tiktokv.com/aweme/v1/play/?video_id=v12044gd0000c6sncn3c77ucvhruqutg&line=0&is_play_url=1&source=PackSourceEnum_FEED&file_id=8be23354295d4da6abdc932e972b7ad2\"\n" +
                "            ],\n" +
                "            \"width\": 576\n" +
                "        },\n" +
                "        \"ratio\": \"540p\",\n" +
                "        \"width\": 576\n" +
                "    },\n" +
                "    \"video_control\": {\n" +
                "        \"allow_download\": true,\n" +
                "        \"allow_duet\": true,\n" +
                "        \"allow_dynamic_wallpaper\": true,\n" +
                "        \"allow_music\": true,\n" +
                "        \"allow_react\": true,\n" +
                "        \"allow_stitch\": true,\n" +
                "        \"draft_progress_bar\": 0,\n" +
                "        \"prevent_download_type\": 0,\n" +
                "        \"share_type\": 1,\n" +
                "        \"show_progress_bar\": 0,\n" +
                "        \"timer_status\": 1\n" +
                "    },\n" +
                "    \"video_labels\": [],\n" +
                "    \"video_text\": [],\n" +
                "    \"with_promotional_music\": false,\n" +
                "    \"with_survey\": false\n" +
                "}";
        AwemeStructV2 awemeStructV2 = new GsonBuilder().create().fromJson(awemeJson, AwemeStructV2.class);
        System.out.println(awemeStructV2.getAwemeId());
    }
}