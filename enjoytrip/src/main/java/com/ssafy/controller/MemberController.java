package com.ssafy.controller;

import com.ssafy.service.JwtServiceImpl;
import com.ssafy.service.MemberService;
import com.ssafy.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class MemberController {

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private MemberService memberService;


	@CrossOrigin("*")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody Member member) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			logger.info("{}", member.getPass());
			Member loginUser = memberService.login(member);
			if (loginUser != null) {
				System.out.println(loginUser.getId());
				String accessToken = jwtService.createAccessToken("id", loginUser.getId());// key, data
				String refreshToken = jwtService.createRefreshToken("id", loginUser.getId());// key, data
				memberService.saveRefreshToken(member.getId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
				System.out.println("fail");
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}


	@CrossOrigin("*")
	@GetMapping("/info/{id}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("id") String id,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		logger.info("{}", id);
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				Member memberDto = memberService.userInfo(id);
				logger.info("{}",memberDto);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@CrossOrigin("*")
	@GetMapping("/logout/{id}")
	public ResponseEntity<?> removeToken(@PathVariable("id") String id) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberService.deleRefreshToken(id);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}


	@CrossOrigin("*")
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody Member memberDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, memberDto);
		if (jwtService.checkToken(token)) {
			if (token.equals(memberService.getRefreshToken(memberDto.getId()))) {
				String accessToken = jwtService.createAccessToken("id", memberDto.getId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@CrossOrigin("*")
	@PostMapping(value="")
	public int insert(@RequestBody Member member) throws Exception {
		return memberService.insert(member);
	}

	@CrossOrigin("*")
	@PutMapping(value = "")
	public int update(@RequestBody Member member) throws Exception {
		return memberService.update(member);
	}

	@CrossOrigin("*")
	@DeleteMapping(value = "/{id}")
	public int delete(@PathVariable String id) throws Exception {
		logger.info("{}", id);
		return memberService.delete(id);
	}

	@CrossOrigin("*")
	@GetMapping(value = "/check/{id}")
	public boolean dupCheck(@PathVariable String id) throws Exception {
		logger.info("{}", id);
		return memberService.dupCheck(id);
	}


}
