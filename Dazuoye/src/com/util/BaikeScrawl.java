package com.util;

import java.security.NoSuchAlgorithmException;

import com.dao.IWordDao;
import com.dao.WordDaoImpl;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BaikeScrawl implements PageProcessor  {
	private static String name;
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	public void run(String name) {// 1

		this.name = name;
		Spider.create(new BaikeScrawl()).addUrl("https://baike.baidu.com/item/" + name).thread(5).run();
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	@Override
	public void process(Page page) {// 2
		System.setProperty("https.protocols", "TLSv1");
		String expl = page.getHtml().xpath("//meta[@name='description']/@content").toString();// 找到name='description'的meta,获取meta的content属性的内容
		String webname = page.getHtml().xpath("//*[@class=\"reference-item reference-item--type1\"][1]/a[2]/text()").toString();
		String webaddr = page.getHtml().xpath("//*[@class=\"reference-item reference-item--type1\"][1]/a[2]/@href").toString();
		IWordDao dao = new WordDaoImpl();
		dao.add(name, expl,webname,webaddr);
		page.addTargetRequest("https://so.csdn.net/so/search/s.do?q=" + name);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		BaikeScrawl baikeScrawl = new BaikeScrawl();
		baikeScrawl.run("区块链");
	}
}
