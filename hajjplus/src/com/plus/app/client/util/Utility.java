package com.plus.app.client.util;

public class Utility {

private static LoadingDlg dlg=new LoadingDlg(false, true);

static int count= 0 ;

public static void showLoading(){
    if(count <= 0){


        dlg.center();
        count = 1;
    }
    else
    count++;

}
public static void hideLoading(){
    if(count <= 1){
        dlg.hide();     
        count = 0;
    }
    else{
    count--;
    }
}

}






