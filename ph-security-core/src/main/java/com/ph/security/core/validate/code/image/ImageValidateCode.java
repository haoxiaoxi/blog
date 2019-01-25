package com.ph.security.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.ph.security.core.validate.code.ValidateCode;

/**
 * 图片验证码
 * @author panha
 *
 */
public class ImageValidateCode extends ValidateCode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6330521640926118372L;
	
	private BufferedImage image;

	public ImageValidateCode(BufferedImage image,String code, int expireIn) {
		super(code, expireIn);
		this.image = image;
	}
	
	public ImageValidateCode(BufferedImage image,String code, LocalDateTime expireTime) {
		super(code, expireTime);
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	

}
