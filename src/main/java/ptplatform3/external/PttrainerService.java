
package ptplatform3.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

//@FeignClient(name="Pttrainer", url="http://Pttrainer:8080")
//public interface PttrainerService {
//
//    @RequestMapping(method= RequestMethod.POST, path="/pttrainers")
//    public void ptScheduleCancellation(@RequestBody Pttrainer pttrainer);
//
//}

@FeignClient(name="feignpttrainer", url="${feignpttrainer.url}")
public interface PttrainerService {

    // @PostMapping(value="/pttrainer/{ptOrderId}")
    // public void ptScheduleCancellation(@PathVariable("ptOrderId") Long ptOrderId, String status);

    @RequestMapping(method = RequestMethod.POST, value = "/pttrainers")
    // Store update(@PathVariable("storeId") Long storeId, Store store);
    public void ptScheduleCancellation(@PathVariable("ptOrderId") Long ptTrainerId, @PathVariable("status") String status);
}