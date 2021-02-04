package es.bcn.gpa.gpaserveis.web.initialization.strategy.concurrent;

import java.util.Locale;
import java.util.concurrent.Callable;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public final class DelegatingSecurityContextCallable<V> implements Callable<V> {
	private final Callable<V> delegate;
	private final SecurityContext delegateSecurityContext;
	private final RequestAttributes delegateRequestAttributes;
	private final Locale delegateLocale;
	private SecurityContext originalSecurityContext;
	private RequestAttributes originalRequestAttributes;
	private Locale originalLocale;

	public DelegatingSecurityContextCallable(Callable<V> delegate, SecurityContext securityContext, RequestAttributes requestAttributes,
			Locale locale) {
		Assert.notNull(delegate, "delegate cannot be null");
		Assert.notNull(securityContext, "securityContext cannot be null");
		this.delegate = delegate;
		this.delegateSecurityContext = securityContext;
		this.delegateRequestAttributes = requestAttributes;
		this.delegateLocale = locale;
	}

	public DelegatingSecurityContextCallable(Callable<V> delegate) {
		this(delegate, SecurityContextHolder.getContext(), RequestContextHolder.getRequestAttributes(), LocaleContextHolder.getLocale());
	}

	public V call() throws Exception {
		this.originalSecurityContext = SecurityContextHolder.getContext();
		this.originalRequestAttributes = RequestContextHolder.getRequestAttributes();
		this.originalLocale = LocaleContextHolder.getLocale();
		boolean var6 = false;

		V var1;
		try {
			var6 = true;
			SecurityContextHolder.setContext(this.delegateSecurityContext);
			RequestContextHolder.setRequestAttributes(this.delegateRequestAttributes);
			LocaleContextHolder.setLocale(this.delegateLocale);
			var1 = this.delegate.call();
			var6 = false;
		} finally {
			if (var6) {
				SecurityContext var4 = SecurityContextHolder.createEmptyContext();
				if (var4.equals(this.originalSecurityContext)) {
					SecurityContextHolder.clearContext();
				} else {
					SecurityContextHolder.setContext(this.originalSecurityContext);
				}

				this.originalSecurityContext = null;
			}
		}

		SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
		if (emptyContext.equals(this.originalSecurityContext)) {
			SecurityContextHolder.clearContext();
		} else {
			SecurityContextHolder.setContext(this.originalSecurityContext);
		}

		this.originalSecurityContext = null;
		return var1;
	}

	public String toString() {
		return this.delegate.toString();
	}

	public static <V> Callable<V> create(Callable<V> delegate, SecurityContext securityContext, RequestAttributes requestAttributes,
			Locale locale) {
		return securityContext == null ? new DelegatingSecurityContextCallable(delegate, null, requestAttributes, locale)
				: new DelegatingSecurityContextCallable(delegate, securityContext, requestAttributes, locale);
	}
}