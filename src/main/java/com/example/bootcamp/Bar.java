package com.example.bootcamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//annotation tells spring to figure out where it's at, and how to find it.
//the frame work will see it and manage it for you
@Component
class Bar {

	private final Foo foo;

	private final Log log = LogFactory.getLog(getClass());

	// constractor injecting Foo into Bar
	// uuid: using spell and we just injected the uuid , spring provides it for us using
	// spell.
	// and yes uuid is a @Component
	Bar(Foo foo, @Value("#{ uuid.buildUuid()}") String uuid,
			@Value("#{  2 > 1 }") boolean proceed) {
		this.foo = foo;
		this.log.info("UUID: " + uuid);
		this.log.info("proceed: " + proceed);
	}

}
