package com.kunzisoft.keepass.activities.fragments

import android.os.Bundle
import android.view.View
import com.kunzisoft.keepass.R
import com.kunzisoft.keepass.adapters.IconAdapter
import com.kunzisoft.keepass.database.element.Database
import com.kunzisoft.keepass.database.element.icon.IconImage

/**
 * Content fragments
 */

class IconCustomFragment : IconFragment() {

    override fun retrieveMainLayoutId(): Int {
        return R.layout.fragment_icon_custom_picker
    }

    override fun defineIconList(database: Database): List<IconImage> {
        return database.iconPool.getCustomIconList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iconAdapter.iconPickerListener = object : IconAdapter.IconPickerListener {
            override fun iconPicked(icon: IconImage) {
                iconPickerViewModel.selectIconCustom(icon.custom)
            }
        }
    }
}