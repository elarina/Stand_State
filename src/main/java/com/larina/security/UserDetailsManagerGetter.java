package com.larina.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDetailsManagerGetter {
//	@Bean
//	UserDetailsManager users(DataSource dataSource) {
//		UserDetails user = User.builder()
//			.username("user")
//			.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
//			.roles("USER")
//			.build();
//		UserDetails admin = User.builder()
//			.username("admin")
//			.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
//			.roles("USER", "ADMIN")
//			.build();
//		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		users.createUser(user);
//		users.createUser(admin);
//		return users;
//	}
}
