package com.bacecek.translate.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bacecek.translate.App;
import com.bacecek.translate.data.db.LanguageManager;
import com.bacecek.translate.data.db.RealmController;
import com.bacecek.translate.mvp.view.ChooseLanguageView;
import javax.inject.Inject;

/**
 * Created by Denis Buzmakov on 11/04/2017.
 * <buzmakov.da@gmail.com>
 */

@InjectViewState
public class ChooseLanguagePresenter extends MvpPresenter<ChooseLanguageView> {
	@Inject
	RealmController mRealmController;
	@Inject
	LanguageManager mLanguageManager;
	private int mChooseLangType;

	public ChooseLanguagePresenter() {
		App.getAppComponent().inject(this);
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getViewState().setRecentlyUsedLanguages(mRealmController.getRecentlyUsedLanguages());
		getViewState().setAllLanguages(mRealmController.getLanguagesAsync());
	}

	public void setChooseLangType(int chooseLangType) {
		mChooseLangType = chooseLangType;
	}

	public void onItemClick(String lang) {
		getViewState().setResultAndFinish(lang, mChooseLangType);
	}

	public void datasetRecentlyUsedChanged(int size) {
		if(size == 0) {
			getViewState().setRecentlyUsedVisibility(false);
		} else {
			getViewState().setRecentlyUsedVisibility(true);
		}
	}
}