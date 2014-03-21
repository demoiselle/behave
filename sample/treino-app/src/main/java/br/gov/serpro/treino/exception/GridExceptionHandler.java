package br.gov.serpro.treino.exception;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import br.gov.serpro.treino.view.managedbean.FacesUtil;

public class GridExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler exceptionHandler;

	public GridExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.exceptionHandler;
	}

	@Override
	public void handle() throws FacesException {
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
			
			ExceptionQueuedEvent exceptionQueuedEvent = i.next();
			ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) exceptionQueuedEvent.getSource();
			Throwable throwable = exceptionQueuedEventContext.getException();
			
			if (throwable instanceof Throwable) {
				Throwable t = (Throwable) throwable;
				if (t.getCause() instanceof TestGridException) {
					TestGridException e = (TestGridException) t.getCause();
					FacesUtil.addMessage(e.getObjectMessage(), e.getParams());
				} else if(t instanceof ViewExpiredException){ 
					 ViewExpiredException vee = (ViewExpiredException) t;
		                FacesContext fc = FacesContext.getCurrentInstance();
		                NavigationHandler nav = fc.getApplication().getNavigationHandler();
		                try {
		                    fc.getExternalContext().getFlash().put("expiredViewId", vee.getViewId());
		                    nav.handleNavigation(fc, null, "/private/pages/index?faces-redirect=true");
		                    fc.renderResponse();
		                } finally {
		                    i.remove();
		                }
				}else {
					String[] param = { throwable.getMessage() };
					FacesUtil.addMessage(ErrorMessage.UNEXPECTED, param, throwable);
				}
			}
		}
	}

}
