(ns pdfbox-envelope-printer.core
  (:gen-class)
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io])
  (:import [org.apache.pdfbox.pdmodel PDDocument PDPage PDPageContentStream]
           [org.apache.pdfbox.pdmodel.font PDFont PDType0Font]
           [org.apache.fontbox.ttf OTFParser]
           [org.apache.pdfbox.pdmodel.common PDRectangle]))

(def ^:private POINTS_PER_INCH 72)
(def ^:private POINTS_PER_MM (float (* (/ 1 25.4) POINTS_PER_INCH)))
(def ^:private 長3 (PDRectangle. (* 120 POINTS_PER_MM) (* 235 POINTS_PER_MM)))

(defn- append-text!
  [stream font font-size x y content]
  (.beginText stream)
  (.setFont stream font font-size)
  (.newLineAtOffset stream (float x) (float y))
  (.showText stream content)
  (.endText stream))

(defn- append-page!
  [document font {:keys [zipcode address1 address2 company-name department-name]}]
  (let [page (PDPage. 長3)]
    (.addPage document page)
    (with-open [stream (PDPageContentStream. document page)]
      (append-text! stream font 12 70 450 zipcode)
      (when address1 (append-text! stream font 11 70 435 address1))
      (when address2 (append-text! stream font 11 70 420 address2))
      (append-text! stream font 15 70 390 company-name)
      (when department-name (append-text! stream font 15 70 360 department-name))
      (append-text! stream font 15 250 330 "御中"))))

(defn- create-envelopes
  [reqs]
  (with-open [document (PDDocument.)]
    (let [otf-parser (OTFParser. true true)
          otf-font (.parse otf-parser (io/file (io/resource "NotoSansJP-Regular.otf")))
          font (PDType0Font/load document otf-font false)
          ;; font (PDType0Font/load document (io/file (io/resource "")))
          ]
      (doseq [req reqs]
        (append-page! document font req))
      (.save document "test.pdf")
      (.close document))))

(defn -main
  [& args]
  (with-open [reader (io/reader "source.csv")]
    (->> (csv/read-csv reader)
         (map (fn [[zipcode address1 address2 company-name department-name]]
                {:zipcode zipcode
                 :address1 address1
                 :address2 address2
                 :company-name company-name
                 :department-name department-name}))
         create-envelopes)))
