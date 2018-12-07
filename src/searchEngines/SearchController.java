package searchEngines;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
public class SearchController {

	private String seq;
	private String google = "http://www.google.com/search?q=";
	private String bing = "https://www.bing.com/search?q=";

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String search() throws IOException {
		if (seq.isEmpty()) {
			return "empty-search-string";
		} else {
			int random = ThreadLocalRandom.current().nextInt(0 , 1 +1);
			String searchURL = "";
			if(random == 0) {
				searchURL = google + seq;
			} else {
				searchURL = bing + seq;
			}
			
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletResponse response = (HttpServletResponse) context.getResponse();
			response.sendRedirect(searchURL);

			return null;
		}
	}
}
