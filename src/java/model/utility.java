/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author sarunpeetasai
 */
public class utility {
    public static String genInstrustion(double eAG){
        String result ="";
        if(eAG > 160){
            result = "ซึ่งเป็นค่าที่สูง เราขอแนะนำให้คุณควบคุมน้ำตาลให้ได้ต่ำกว่า 154 mg/dl เพื่อป้องกันโรคแทรกซ้อน";
        }else{
             result = "ซึ่งเป็นค่าที่ดีเยี่ยม รักษาระดับน้ำตาลของคุณให้ได้เท่านี้หรือน้อยกว่า เพื่อป้องกันโรคแทรกซ้อนต่างๆ";
        }
        return result;
    }
    public static String toUTF8(String text) {
        String result = null;
        try {
            result = new String(text.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            result = null;
        }
        return result;
    }
}
