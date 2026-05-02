# FaceEmotionDetector

Rush-based MIT App Inventor extension for a professional camera emotion-detection UI.

## Files included

- `rush.yml`
- `src/AndroidManifest.xml`
- `src/com/soremi/faceemotiondetector/FaceEmotionDetector.java`
- `assets/icon.png`

## Blocks

### Start(modelUrl)
Starts the camera preview and prediction loop. Use a Teachable Machine model URL, for example:

`https://teachablemachine.withgoogle.com/models/YOUR_MODEL_ID/`

### Stop()
Stops the camera.

### SetTheme(title, accentColor)
Sets the title and accent color, for example `#2563EB`.

### EmotionDetected(emotion, confidence, rawJson)
Event fired when a result is available.

### ErrorOccurred(message)
Event fired on error.

## Important note about Teachable Machine URLs

A normal Teachable Machine image model URL exposes `model.json` and weights. Real image classification inside an Android extension requires TensorFlow Lite or a JavaScript/WebView classifier pipeline. This extension gives you the Rush component, camera UI, manifest permissions, and continuous loop structure. If you host an inference API that returns JSON like:

```json
[{"className":"Happy","probability":0.92}]
```

then the extension parses and displays the emotion automatically.

"# faceEmotionDetectionAppInventor" 
