package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.configuration.security.JwtUtil;
import sv.edu.udb.controller.request.UserRequest;
import sv.edu.udb.controller.response.UserResponse;
import sv.edu.udb.repository.UserRepository;
import sv.edu.udb.repository.domain.SecurityUser;
import sv.edu.udb.service.SecUserService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "authentications")
public class AuthController {

    private final JwtUtil jwtUtils;
    private final SecUserService secUserService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;


    @PostMapping(path = "sign-in")
    public String authenticateUser(@RequestBody final UserRequest userRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()));

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String username = userDetails.getUsername();
        final String role = secUserService.getUserRole(username); // ✅ trae el rol del usuario

        return jwtUtils.generateToken(username, role); // ✅ genera token con rol
    }


    @PostMapping("sign-up")
    @ResponseStatus(CREATED)
    public UserResponse registerUser(@Valid @RequestBody final UserRequest userRequest) {
        return secUserService.createUser(userRequest);
    }
    @GetMapping("role")
    public String getAuthenticatedUserRole(Authentication authentication) {
        String username = authentication.getName(); // Extrae el usuario desde el token
        return secUserService.getUserRole(username); // Consulta el rol desde la DB
    }

    @GetMapping("/debug/users")
    public List<SecurityUser> getAllUsers() {
        return userRepository.findAll();
    }

}
