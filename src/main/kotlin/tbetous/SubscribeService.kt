package tbetous

import com.google.appengine.api.ThreadManager
import org.springframework.stereotype.Service
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.springframework.core.env.Environment
import org.springframework.social.twitter.api.impl.TwitterTemplate
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@Service
class SubscribeService(val environment: Environment) {

    private var count = 0
    private var subscriber : Disposable? = null
    private var twitter : TwitterTemplate = TwitterTemplate(
            environment.getProperty("twitter.consumerKey"),
            environment.getProperty("twitter.consumerSecret"),
            environment.getProperty("twitter.accessToken"),
            environment.getProperty("twitter.accessTokenSecret"))

    fun subscribe() {
        val scheduler : Scheduler = Schedulers.from(ScheduledThreadPoolExecutor(3, ThreadManager.backgroundThreadFactory()))
        RxJavaPlugins.setComputationSchedulerHandler { scheduler }
        unsubscribe()
        subscriber = Observable.interval(1, TimeUnit.SECONDS)
                .map { twitter.userOperations().getUserProfile("zenikaIt").followersCount }
                .subscribe {it -> count = it}
    }

    fun unsubscribe() {
        subscriber?.dispose()
    }

    fun getCount() = count

}