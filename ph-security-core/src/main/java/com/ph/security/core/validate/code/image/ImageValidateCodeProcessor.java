package com.ph.security.core.validate.code.image;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.ph.security.core.validate.code.impl.AbstractValidateCodeProcessor;

@Component("imageValidateCodeProcessor")
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageValidateCode> {

	@Override
	protected void send(ServletWebRequest request, ImageValidateCode imageValidateCode) throws Exception {
		ImageIO.write(imageValidateCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}

}
