package com.niit.skillmapweb.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer 
{

	@Override
	protected Class[] getRootConfigClasses()
	{
		return new Class[] {ApplicationConfiguration.class };
	}

	@Override
	protected Class[] getServletConfigClasses() 
	{
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}