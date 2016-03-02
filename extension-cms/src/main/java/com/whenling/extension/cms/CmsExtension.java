package com.whenling.extension.cms;

import org.springframework.stereotype.Component;

import com.whenling.centralize.Application;
import com.whenling.centralize.Extension;
import com.whenling.centralize.model.Menu;

/**
 * CMS扩展
 * 
 * @作者 孔祥溪
 * @博客 http://ken.whenling.com
 * @创建时间 2016年3月1日 下午4:34:59
 */
@Component
public class CmsExtension extends Extension {

	@Override
	public void init(Application app, boolean isNew, boolean isUpdate, Integer historyVersion) {
		if (isNew) {
			Menu contentMenu = app.addMenu("内容管理", "content", null, null, null, null);
			app.addMenu("模板管理", "template", "Page", "app.view.cms.Template", null, contentMenu);
		}
	}

	@Override
	public Integer getVersion() {
		return 1;
	}

	@Override
	public String getAuthor() {
		return "ken";
	}

}