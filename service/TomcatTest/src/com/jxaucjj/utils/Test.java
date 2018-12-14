package com.jxaucjj.utils;

import java.io.*;
import com.alibaba.fastjson.*;
import com.jxaucjj.utils.*;

public class Test {
	public static void main(String[] args) {
		
		try {
			
			PrintWriter write=new PrintWriter("D:/HTML/json.txt");
			
			write.println(JSON.toJSONString(new Friend("image/2.jpg","郭靖",
					 "风吹雨成花，时间追不上白马。你年少掌心的梦话，依然紧握着吗？"
					 + "云翻涌成夏，眼泪被岁月蒸发，这条路上的你我她，有谁迷路吗……",new String[] {"img/content (1).jpeg,img/content (2).jpg"}))
			);
			write.println(JSON.toJSONString(new Friend("image/3.png","黄蓉",
					"轻启轩窗，春燕盘旋，杨柳依依，芳草青青，花影斑驳，桃李芳菲尽，夏花次第开。"
							+ "五月的风儿，轻轻的柔柔的暖暖的亲吻过脸颊，鼻间新绿的清香泉水般“汩汩”的流淌",new String[] {"img/content (3).jpg"}))
			);
			write.println(JSON.toJSONString(new Friend("image/4.jpg","杨康",
					"轻触时光，一些念，若雨，滴落心间；一些梦，若云，时隐时现。时光，是指尖的流沙，"
					+ "握不住的水色年华。来不及凝眸，所有的浮华，都成了不堪剪的烟花",new String[] {"img/content (4).jpg,img/content (5).jpg","img/content(6).jpg"}))
			);
			write.println(JSON.toJSONString(new Friend("image/5.jpg","乔峰",
					"捧起一捧故乡土，那是无尽的思念。 描写乡情的美文 抬头凝望着那在雾中忽闪忽现的月亮，手中捧着那从家乡带来的茶叶泡出的茶，"
					+ "眼中弥漫因茶香而散发的水雾，水雾氤氲在我眼前，空中的",new String[] {"img/content (6).jpeg,img/content (7).jpg"}))
			);
			write.println(JSON.toJSONString(new Friend("image/6.jpg","段誉",
					 "",new String[] {"img/content (8).jpg,img/content (9).jpg","img/content (10).jpg"}))
			);
			write.println(JSON.toJSONString(new Friend("image/7.jpg","虚竹",
					"苦与甜的变奏 成华彪 又到瓜熟蒂落的时节。想抢鲜吃到新上市的瓜果，尝点苦头是难免的。"
					+ "这不，前几天买回时鲜香瓜，一不小心就买着了生瓜，苦得没法下咽。",new String[] {"img/content (11).jpg"}))
			);
			
			write.flush();
			write.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
