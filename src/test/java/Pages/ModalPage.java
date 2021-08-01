package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalPage {
  WebDriver driver;

  @FindBy(id = "post-product-comment-modal")
  WebElement commentModal;

  @FindBy(id = "product-comment-posted-modal")
  WebElement commentPostedModal;

  @FindBy(name = "comment_title")
  WebElement commentTitle;

  @FindBy(name = "comment_content")
  WebElement review;

  @FindBy(xpath = "//button[contains(text(),'Send')]")
  WebElement sendButton;

  @FindBy(id = "product-comment-posted-modal-message")
  WebElement successfulAddingCommentMessage;

  public ModalPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getCommentModal() {
    return commentModal;
  }

  public WebElement getCommentPostedModal() {
    return commentPostedModal;
  }

  public WebElement getCommentTitle() {
    return commentTitle;
  }

  public WebElement getReview() {
    return review;
  }

  public WebElement getSendButton() {
    return sendButton;
  }

  public WebElement getSuccessfulAddingCommentMessage() {
    return successfulAddingCommentMessage;
  }
}
