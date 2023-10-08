package com.example.gamecollection.utils

class FormatHelper {
    companion object {
        fun formatDescription(description:String):String{
            return description.replace("<p>","")
                .replace("</p>","\n")
                .replace("&#39","'")
                .replace("<br />","")
        }
        fun formatGameName(gameName:String):String{
            return gameName.replace(" ","-")
                .replace("/","")
                .replace("\\","")
                .replace(":","")
                .replace("?","")
                .replace("¿","")
                .replace(")","")
                .replace("(","")
                .replace(")","")
            
        }
    }
}