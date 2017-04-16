package com.bacecek.translate.di.module;

import com.bacecek.translate.data.network.TranslatorAPI;
import com.bacecek.translate.utils.Consts.DI;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by Denis Buzmakov on 10/04/2017.
 * <buzmakov.da@gmail.com>
 */

@Module
public class TranslatorModule {

	@Provides
	@Singleton
	TranslatorAPI provideTranslatorApi(@Named(DI.DI_TRANSLATOR_RETROFIT) Retrofit retrofit) {
		return retrofit.create(TranslatorAPI.class);
	}

}
