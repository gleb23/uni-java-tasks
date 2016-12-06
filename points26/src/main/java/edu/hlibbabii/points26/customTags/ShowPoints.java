package edu.hlibbabii.points26.customTags;

import edu.hlibbabii.points26.service.Point;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class ShowPoints extends TagSupport {

    private Collection<Point> points;

    public void setPoints(Collection<Point> points) {
        this.points = points;
    }

    @Override
    public int doStartTag() throws JspTagException {
        try {
            pageContext.getOut().write(
                    "<table border=\"2\"><thead><tr><th>X</th><th>Y</th>"
                    + "</thead><tbody><tr>");
            Iterator iterator = points.iterator();
            while (iterator.hasNext()) {
                Point point = (Point) iterator.next();
                pageContext.getOut().write(
                        "<td>" + point.getX() + "</td>"
                        + "<td>" + point.getY() + "</td>"
                        + "</tr>");
            }
            pageContext.getOut().write("</tbody></table>");
        } catch (IOException ex) {
            throw new JspTagException(ex.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }
}
