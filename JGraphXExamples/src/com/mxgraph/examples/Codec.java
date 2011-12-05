package com.mxgraph.examples;

import org.w3c.dom.Document;

import com.mxgraph.io.mxCodec;
import com.mxgraph.util.mxUtils;

public class Codec
{

	protected boolean test = false;

	public Codec()
	{
		// empty
	}

	public boolean isTest()
	{
		return test;
	}

	public void setTest(boolean test)
	{
		this.test = test;
	}

	public static void main(String[] args)
	{
		// mxCodec wants simple class names, so packages must be known
		//mxCodecRegistry.addPackage("com.mxgraph.examples");

		mxCodec codec = new mxCodec();

		Codec obj = new Codec();
		obj.setTest(true);

		String xml = mxUtils.getXml(codec.encode(obj));
		System.out.println("encoded: " + xml);

		Document doc = mxUtils.parseXml(xml);

		codec = new mxCodec(doc);
		obj = (Codec) codec.decode(doc.getDocumentElement());

		System.out.println("decoded: " + obj);

		xml = mxUtils.getXml(codec.encode(obj));
		System.out.println("encoded: " + xml);
	}

}
