package com.lj.core.net.msg

abstract class BaseHandler{
    abstract  fun process(socketId:String, msg:Msg);
}