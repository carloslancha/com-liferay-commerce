/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.taglib.servlet.taglib;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.commerce.taglib.internal.js.loader.modules.extender.npm.NPMResolverProvider;

import com.liferay.frontend.taglib.soy.servlet.taglib.ComponentRendererTag;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Alessio Antonio Rendina
 */
public class AutocompleteTag extends ComponentRendererTag {

	@Override
	public int doStartTag() {
		String randomNamespace = StringUtil.randomId() + StringPool.UNDERLINE;

		putValue("id", randomNamespace + "id");
		putValue("suggestions", JSONFactoryUtil.createJSONArray());

		setTemplateNamespace("CommerceAutocomplete.render");

		return super.doStartTag();
	}

	@Override
	public String getModule() {
		NPMResolver npmResolver = NPMResolverProvider.getNPMResolver();

		if (npmResolver == null) {
			return StringPool.BLANK;
		}

		return npmResolver.resolveModuleName(
			StringBundler.concat(
				"commerce-taglib/autocomplete/CommerceAutocomplete.es"));
	}

	public void setDataSource(String dataSource) {
		putValue("dataSource", String.valueOf(dataSource));
	}

	public void setSuggestions(String suggestions) {
		putValue("suggestions", suggestions);
	}

	public void setElementClasses(String elementClasses) {
		putValue("elementClasses", elementClasses);
	}

	public void setId(String id) {
		putValue("id", id);
	}

	public void setQuery(String query) {
		putValue("query", query);
	}

	public void setValue(String value) {
		putValue("value", value);
	}

	public void setSelectedSuggestionIndex(int selectedSuggestionIndex) {
		putValue("selectedSuggestionIndex", selectedSuggestionIndex);
	}

	public void setMaxSuggestions(int maxSuggestions) {
		putValue("maxSuggestions", maxSuggestions);
	}

	public void setHasFocus(boolean hasFocus) {
		putValue("hasFocus", hasFocus);
	}

}