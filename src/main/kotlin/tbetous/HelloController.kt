package tbetous

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

@RestController
class HelloController(val subscribeService: SubscribeService) {

    @RequestMapping("/subscribe")
    fun subscribe() = subscribeService.subscribe()

    @RequestMapping("/unsubscribe")
    fun unsubscribe() = subscribeService.unsubscribe()

    @RequestMapping("/count")
    fun count() = subscribeService.getCount()

}
