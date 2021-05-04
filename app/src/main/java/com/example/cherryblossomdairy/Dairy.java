package com.example.cherryblossomdairy;

import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

public class Dairy extends LitePalSupport {
        private String dairy_title;
        private String dairy_content;


    public String getDairy_title() {
            return dairy_title;
        }

        public String getDairy_content() {
            return dairy_content;
        }

        public void setDairy_title(String dairy_title) {
            this.dairy_title = dairy_title;
        }

        public void setDairy_content(String dairy_content) {
            this.dairy_content = dairy_content;
        }
    }





