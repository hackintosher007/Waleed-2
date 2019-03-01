package com.example.adhfixer.waleed;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Book1 extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);


        String file = getIntent().getStringExtra("file");
        String filename = setFileName(file);
        pdfView = findViewById(R.id.pdfView);
        //   pdfView.fromAsset("mozart.pdf").load();

        //  new retrievePDFStream().execute("http://ancestralauthor.com/download/sample.pdf");


        pdfView.fromAsset(file)
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .load();
        //  new retrievePDFBytes().execute("http://ancestralauthor.com/download/sample.pdf");
    }


    /* class retrievePDFBytes extends AsyncTask<String,Void,byte[]>{

         @Override
         protected byte[] doInBackground(String... strings){
             InputStream inputStream=null;
             try{
                 URL url = new URL(strings[0]);
                 HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
                 if(urlConnection.getResponseCode()==200){
                     inputStream = new BufferedInputStream(urlConnection.getInputStream());

                 }
             }
             catch(IOException e){
                 return null;
             }
             try {
                 return IOUtils.toByteArray(inputStream);
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return null;

         }

         @Override
         protected void onPostExecute(byte[] bytes){
             pdfView.fromBytes(bytes).load();

         }
     }*/
    public String setFileName(String name) {
        if (name.equals("Iberia")) {
            return "ibiria.pdf";
        } else if (name.equals("Liszt")) {
            return "liszt.pdf";
        } else if(name.equals("Scaramouche")) {

            return "milhaud.pdf";


        }
        return null;
    }
}