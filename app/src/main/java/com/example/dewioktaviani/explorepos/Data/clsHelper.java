package com.example.dewioktaviani.explorepos.Data;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Dewi Oktaviani on 12/15/2017.
 */

public class clsHelper {
    public String copydb(Context context) throws IOException{
        String CURRENT_DATABASE_PATH = "data/data/" + context.getPackageName() + "/databases/tesPOS.db";

        try {
            File dbFile = new File(CURRENT_DATABASE_PATH);
            FileInputStream fis = new FileInputStream(dbFile);
            String txtPathUserData= Environment.getExternalStorageDirectory()+File.separator+"ExplorerPOS";
            File yourFile = new File(txtPathUserData);
            yourFile.createNewFile();
            OutputStream output = new FileOutputStream(yourFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            output.flush();
            output.close();
            fis.close();
        } catch (Exception e) {
            String s= e.getMessage();
        }
        return "";
    }
}
