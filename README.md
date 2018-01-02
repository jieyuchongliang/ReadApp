# ReadApp

android中默认一个项目是无法读取其他项目文件夹下的文件的。除非两个项目的sharedUserId相同。<br> 
>>注:<br> 
>>1，相同sharedUserId的应用，系统会分配相同的uid，即两个应用运行在一个进程中。<br> 
>>2，相同sharedUserId的应用，必须用相同的签名工具进行签名才能安装，否则无法安装。<br>

    总结，只要保证几个应用的sharedUserId相同，那么，用相同的签名工具进行签名打包生成的apk，<br>
    可以相互访问不同包名下的文件夹，进行读写。


