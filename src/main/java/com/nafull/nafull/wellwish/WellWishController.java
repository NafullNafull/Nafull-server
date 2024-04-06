package com.nafull.nafull.wellwish;

import com.nafull.nafull.common.ListData;
import com.nafull.nafull.wellwish.data.ReceiveWellWish;
import com.nafull.nafull.wellwish.data.SendWellWish;
import com.nafull.nafull.wellwish.data.WellWish;
import com.nafull.nafull.wellwish.entity.WellWishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/well-wishes")
@RequiredArgsConstructor
public class WellWishController {
    private final WellWishService wellWishService;

    @GetMapping("/{wellWishId}")
    public WellWish findOne(
        @PathVariable final String wellWishId
    ) {
        // 마음함에 담겨있는 편지가 unlock 된 상태였을 때만 볼 수 있음
        return wellWishService.findOne(wellWishId);
    }

    @PostMapping("/receive")
    public void receive(
        @RequestBody final ReceiveWellWish request
    ) {
        // todo
        // 받은 해당 url이 유효한 사람이 전송 받았는가?
        // 처음 마음을 받아서 유저가 회원가입 했을 때 default 값이 랜덤으로 들어가서 타인에게 공유할 수 있게 함
        throw new RuntimeException("Not Implemented!");
    }

    @PostMapping("/send")
    public void send(
        @RequestBody final ListData<SendWellWish> request
    ) {
        wellWishService.sendLetter(request.data());
    }

    @PatchMapping("/{wellWishId}/unlock")
    public void unlock(
        @PathVariable final String wellWishId
    ) {
        throw new RuntimeException("Not Implemented!");
    }
}
