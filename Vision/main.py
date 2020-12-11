import cv2
import numpy as np
from grip import GripPipeline


def get_largest_contour(contours):
    return max(contours, key=lambda contour: cv2.boundingRect(contour)[2])


def start_process(cv_sink, nt_instance):
    data_entry = nt_instance.getTable("Vision").getEntry("data")
    data_entry.setDefaultString("-1 -1")
    pipeline = GripPipeline()

    while True:
        _, frame = cv_sink.grabFrame(np.zeros((480, 640, 3), dtype=np.uint8))
        pipeline.process(frame)
        contours = pipeline.find_contours_output
        if len(contours):
            contour = get_largest_contour(contours)
            moments = cv2.moments(contour)
            try:
                center_x = int(moments["m10"] / moments["m00"])
                x, y, width, height = cv2.boundingRect(contour)
                data_entry.setString("{} {}".format(center_x, width))
                print("Contour:",center_x, width)
            except ZeroDivisionError:
                data_entry.setString("-1 -1")
        else:
            data_entry.setString("-1 -1")
