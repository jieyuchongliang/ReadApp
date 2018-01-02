package com.fujisoft.readapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnRead = (Button) findViewById(R.id.btn_read);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_read:
                read();
                break;
        }
    }

    private static final String TAG = "MainActivity";

    /**
     * 读取按钮的点击事件
     */
    private void read() {
        Log.i(TAG, "项目包名: " + getPackageName());
        File dummyDataFile = new File("/data/data/com.fujisoft.writeapp/dummydata");//目标文件夹（写入）
        if (!dummyDataFile.exists()) {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        fileDetail(dummyDataFile);
    }

    /**
     * 即将读取的文件夹的详细信息
     *
     * @param dummydata
     */
    private void fileDetail(File dummydata) {
        int fileNum = 0, folderNum = 0;
        if (dummydata.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = dummydata.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    Log.i(TAG, "---log输出:文件夹+" + file2.getAbsolutePath());
                    list.add(file2);
                    folderNum++;
                } else {
                    Log.i(TAG, "---log输出:文件+" + file2.getAbsolutePath());
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        Log.i(TAG, "---log输出:文件夹+" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
                        Log.i(TAG, "---log输出:文件+" + file2.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
            Log.i(TAG, "---log输出:文件不存在! ");
        }
    }
}
