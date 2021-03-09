package com.ramonuribe.titangramws.shared.utils;
import de.bripkens.gravatar.DefaultImage;
import de.bripkens.gravatar.Gravatar;
import de.bripkens.gravatar.Rating;
import org.springframework.stereotype.Component;

@Component
public class GravatarUtil {

    public String generateGravatarImageUrl(String email) {
        String gravatarImageURL = new Gravatar()
                .setSize(50)
                .setHttps(true)
                .setRating(Rating.PARENTAL_GUIDANCE_SUGGESTED)
                .setStandardDefaultImage(DefaultImage.RETRO)
                .getUrl(email);
        return gravatarImageURL;
    }

}
