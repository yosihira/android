package com.example.demo11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// @RestController
// public class chatController {
//     private final chatRepository chatRepository;

//     @Autowired
//     public chatController(chatRepository chatRepository) {
//         this.chatRepository = chatRepository;
//     }

//     @RequestMapping("/api/kozin")
//     public ResponseEntity<String> saveChat(@RequestParam("inputValue") String inputValue) {
//         chatRepository.save(new chat(0, inputValue, 0, inputValue));

//         return ResponseEntity.ok("Data stored successfully");
//     }
// }
// @Controller
// public class chatController{
//     @Autowired
//     chatRepository chatRepository;

//     @RequestMapping("/api/kozin")
//     public ModelAndView chat(@RequestParam(name="inputValue")String inputValue,
//     ModelAndView mv){
//         chatRepository.save(new chat(0, inputValue, 0, inputValue));
//         return mv;
//     }
// }
@Controller
public class chatController {
    @Autowired
    private chatRepository chatRepository;

    @PostMapping("/api/kozin")
    public String saveChat(@RequestBody String inputValue) {
        chatRepository.save(new Chat(0, inputValue, 0, inputValue));
        return "Data stored successfully";
    }
}
