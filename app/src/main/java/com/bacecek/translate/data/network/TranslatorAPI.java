package com.bacecek.translate.data.network;

import com.bacecek.translate.data.entities.Language;
import com.bacecek.translate.data.entities.Translation;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Denis Buzmakov on 20/03/2017.
 * <buzmakov.da@gmail.com>
 */

public interface TranslatorAPI {

	/*@GET("getLangs")
	Call<List<Language>> getLangs(
			@Query("ui") String uiLang
	);*/

	@GET("getLangs")
	Observable<List<Language>> getLangs(
			@Query("ui") String uiLang
	);

	@GET("translate")
	Observable<Translation> translate(
			@Query("text") String text,
			@Query("lang") String lang
	);
}
