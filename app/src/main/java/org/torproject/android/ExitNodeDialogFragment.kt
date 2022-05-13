package org.torproject.android

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import org.torproject.android.service.util.Prefs
import org.torproject.android.service.util.Utils
import java.text.Collator
import java.util.*

class ExitNodeDialogFragment : DialogFragment() {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val currentExit = Prefs.getExitNodes()
        val sortedCountries = TreeMap<String, Locale>(Collator.getInstance())
        COUNTRY_CODES.forEach {
            val locale = Locale("", it)
            sortedCountries[locale.displayCountry] = locale
        }


        val array = arrayOfNulls<String>(COUNTRY_CODES.size + 1)
        array[0] = getString(R.string.globe) + " " + getString(R.string.vpn_default_world)
        sortedCountries.keys.forEachIndexed { index, displayCountry ->
            array[index + 1] = Utils.convertCountryCodeToFlagEmoji(sortedCountries[displayCountry]!!.country) +
                    " " + displayCountry
        }

        return AlertDialog.Builder(context)
            .setNegativeButton(android.R.string.cancel) {d, _ -> d.dismiss()}
            .setTitle(R.string.btn_change_exit)
            .setItems(array) {_, pos ->
                var country = ""
                when(pos) {
                    0 -> {} // global
                    else -> {
                    }
                }
            }
            .create()
    }

    companion object {
        private val COUNTRY_CODES = arrayOf(
            "DE",
            "AT",
            "SE",
            "CH",
            "IS",
            "CA",
            "US",
            "ES",
            "FR",
            "BG",
            "PL",
            "AU",
            "BR",
            "CZ",
            "DK",
            "FI",
            "GB",
            "HU",
            "NL",
            "JP",
            "RO",
            "RU",
            "SG",
            "SK"
        )

    }
}