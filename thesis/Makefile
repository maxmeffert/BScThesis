.PHONY: all

all: thesis.pdf

thesis.pdf: thesis.tex 
	pdflatex -src -interaction=nonstopmode thesis.tex
	biber thesis.bcf
	pdflatex -src -interaction=nonstopmode thesis.tex
	pdflatex -src -interaction=nonstopmode thesis.tex
