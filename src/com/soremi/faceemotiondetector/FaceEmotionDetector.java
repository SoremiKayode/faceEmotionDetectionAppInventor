package com.soremi.faceemotiondetector;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

@SimpleObject(external = true)
@DesignerComponent(
    version = 1,
    description = "Face emotion detector extension scaffold.",
    category = ComponentCategory.EXTENSION,
    nonVisible = true)
public class FaceEmotionDetector extends AndroidNonvisibleComponent {

  private String title = "Face Emotion Detector";
  private String accentColor = "#2563EB";

  public FaceEmotionDetector(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction(description = "Starts the detector with the provided model URL.")
  public void Start(String modelUrl) {
    if (modelUrl == null || modelUrl.trim().isEmpty()) {
      ErrorOccurred("Model URL is required.");
      return;
    }
    EmotionDetected("Idle", 0.0, "[]");
  }

  @SimpleFunction(description = "Stops the detector.")
  public void Stop() {
    // Placeholder for camera/inference shutdown.
  }

  @SimpleFunction(description = "Sets UI title and accent color.")
  public void SetTheme(String title, String accentColor) {
    if (title != null && !title.trim().isEmpty()) {
      this.title = title;
    }
    if (accentColor != null && !accentColor.trim().isEmpty()) {
      this.accentColor = accentColor;
    }
  }

  @SimpleFunction(description = "Returns the configured title.")
  public String GetTitle() {
    return title;
  }

  @SimpleFunction(description = "Returns the configured accent color.")
  public String GetAccentColor() {
    return accentColor;
  }

  @SimpleEvent(description = "Fired when an emotion is detected.")
  public void EmotionDetected(String emotion, double confidence, String rawJson) {
    EventDispatcher.dispatchEvent(this, "EmotionDetected", emotion, confidence, rawJson);
  }

  @SimpleEvent(description = "Fired when an error occurs.")
  public void ErrorOccurred(String message) {
    EventDispatcher.dispatchEvent(this, "ErrorOccurred", message);
  }
}
