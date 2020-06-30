package com.benalmadena

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import com.benalmadena.base.BaseActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {
    private lateinit var player: ExoPlayer
    private val dashUrl = "http://nealtoplis.serverroom.net:8254/;"


    private var dataSourceFac: DataSource.Factory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        addFragment(MainActivity(), false, R.id.container_full)
        btnBack.bringToFront()
        imageView4.bringToFront()
        textView2.bringToFront()
        textView3.bringToFront()

        btnBack.setOnClickListener {
            clPlayerView.visibility = View.GONE
            btnOpen.visibility = View.VISIBLE


        }

        btnOpen.setOnClickListener {
            clPlayerView.visibility = View.VISIBLE
            btnOpen.visibility = View.GONE
        }
    }


    override fun onStart() {
        super.onStart()
        playVideoWithSubtitle(dashUrl)
    }

    override fun onStop() {
        releaseExoplayer()
        super.onStop()
    }


    private fun releaseExoplayer() {
        player.release()
    }


    private fun playVideoWithSubtitle(video: String) {
        val defaultBandwidthMeter = DefaultBandwidthMeter()
        val dataSourceFactory = DefaultDataSourceFactory(
            this,
            Util.getUserAgent(this, this.getString(R.string.app_name)),
            defaultBandwidthMeter
        )
        dataSourceFac = dataSourceFactory

        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(defaultBandwidthMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
        val contentMediaSource = buildMediaSourcee(Uri.parse(video))

        val mediaSources = arrayOfNulls<MediaSource>(2) //The Size must change depending on the Uris
        mediaSources[0] = contentMediaSource //uri

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        player.setPlayWhenReady(true)
        simpleExoPlayerView.player = player
        player.prepare(mediaSources[0])
        player = player

        player.addListener(object : Player.EventListener {
            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
                Log.d("TAG", "" + playbackParameters)
            }

            override fun onSeekProcessed() {
                Log.d("TAG", "")
            }

            override fun onTracksChanged(
                trackGroups: TrackGroupArray?,
                trackSelections: TrackSelectionArray?
            ) {
                Log.d("TAG", "" + trackGroups)
            }

            override fun onPlayerError(error: ExoPlaybackException?) {
                Log.d("TAG", "" + error!!.message)
            }

            override fun onLoadingChanged(isLoading: Boolean) {
                Log.d("TAG", "loading [$isLoading]")
            }

            override fun onPositionDiscontinuity(reason: Int) {
                Log.d("TAG", "" + reason)
            }

            override fun onRepeatModeChanged(repeatMode: Int) {
                Log.d("TAG", "" + repeatMode)
            }

            override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
                Log.d("TAG", "" + shuffleModeEnabled)
            }

            override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
                Log.d("TAG", "" + timeline)
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                when (playbackState) {
                    Player.STATE_ENDED -> {
                        if (player != null) {
                            player!!.release()
                        }
                    }
                    Player.STATE_BUFFERING -> {
                        // progressBar.visibility = View.VISIBLE
                    }

                    Player.STATE_READY -> {
                        // progressBar.visibility = View.GONE
                    }

                }

            }
        })
    }

    private fun buildMediaSourcee(uri: Uri): MediaSource {
        @C.ContentType val type = Util.inferContentType(uri)
        when (type) {
            C.TYPE_HLS -> return HlsMediaSource.Factory(dataSourceFac).createMediaSource(uri)
            C.TYPE_OTHER -> return ExtractorMediaSource.Factory(dataSourceFac)
                .createMediaSource(uri)
            else -> throw IllegalStateException("Unsupported type: $type")
        }
    }
}