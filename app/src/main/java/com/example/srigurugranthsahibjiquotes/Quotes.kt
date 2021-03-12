package com.example.srigurugranthsahibjiquotes

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.util.*
import kotlin.random.Random

const val WIDGET_SYNC = "WIDGET_SYNC"

/**
 * Implementation of App Widget functionality.
 */
class Quotes : AppWidgetProvider() {

    private val topicList = mutableListOf("One Universal Creator God. The Name Is Truth. Creative Being Personified. No Fear. No Hatred. Image Of The Undying, Beyond Birth, Self-Existent. By Guru's Grace. - Guru Nanak Dev Ji, 1, Japji Sahib", "Chant And Meditate. - Guru Nanak Dev Ji, 1, Japji Sahib", "True In The Primal Beginning. True Throughout The Ages. - Guru Nanak Dev Ji, 1, Japji Sahib", "True Here And Now. O Nanak, Forever And Ever True. - Guru Nanak Dev Ji, 1, Japji Sahib", "By thinking, He cannot be reduced to thought, even by thinking hundreds of thousands of times. - Guru Nanak Dev Ji, 1, Japji Sahib", "By remaining silent, inner silence is not obtained, even by remaining lovingly absorbed deep within. - Guru Nanak Dev Ji, 1, Japji Sahib", "The hunger of the hungry is not appeased, even by piling up loads of worldly goods. - Guru Nanak Dev Ji, 1, Japji Sahib")

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created

    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled

    }

    override fun onReceive(context: Context, intent: Intent) {

        if (WIDGET_SYNC == intent?.action) {
            val appWidgetId = intent.getIntExtra("appWidgetId", 0)
            updateAppWidget(context, AppWidgetManager.getInstance(context), appWidgetId)
            super.onReceive(context, intent)
        }

    }

    companion object {
        internal fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int
    ) {
            val intent = Intent(context, Quotes::class.java)
            intent.action = WIDGET_SYNC
            intent.putExtra("appWidgetId", appWidgetId)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

            val views = RemoteViews(context.packageName, R.layout.quotes)
            views.setTextViewText(R.id.appwidget_text, Random.nextInt().toString())
            views.setOnClickPendingIntent(R.id.iv_sync, pendingIntent)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }

    }
}