
package org.eclipse.birt.report.designer.internal.ui.views.memento;

import java.util.LinkedList;

import org.eclipse.ui.IMemento;

public class Memento implements IMemento
{

	protected MementoElement memento;
	private MementoBuilder builder;
	

	public Memento( MementoElement memento, MementoBuilder builder )
	{
		this.memento = memento;
		this.builder = builder;
	}


	public IMemento createChild( String id )
	{
		return null;
	}

	public IMemento createChild( String id, String type )
	{
		MementoElement child = builder.createElement( id, type );
		memento.addChild( child );
		return builder.createMemento( child );
	}

	public IMemento getChild( String id )
	{
		// Get the nodes.
		MementoElement[] children = memento.getChildren( );
		int size = children.length;
		if ( size == 0 )
		{
			return null;
		}

		// Find the first node which is a child of this node.
		for ( int nX = 0; nX < size; nX++ )
		{
			MementoElement element = children[nX];
			if ( element.getKey( ).equals( id ) )
			{
				return builder.createMemento( element );
			}

		}

		// A child was not found.
		return null;
	}

	public IMemento[] getChildren( String id )
	{
		MementoElement[] children = memento.getChildren( );
		int size = children.length;
		if ( size == 0 )
		{
			return new Memento[0];
		}
		LinkedList mementoList = new LinkedList( );
		for ( int nX = 0; nX < size; nX++ )
		{
			MementoElement element = children[nX];
			if ( element.getKey( ).equals( id ) )
			{
				mementoList.add( builder.createMemento( element ) );
			}
		}

		IMemento[] mementos = new IMemento[mementoList.size( )];
		mementoList.toArray( mementos );
		return mementos;
	}

	public IMemento[] getChildren( )
	{
		MementoElement[] children = memento.getChildren( );
		int size = children.length;
		if ( size == 0 )
		{
			return new Memento[0];
		}

		IMemento[] mementos = new IMemento[size];
		for ( int nX = 0; nX < size; nX++ )
		{
			MementoElement element = children[nX];
			mementos[nX] = builder.createMemento( element ) ;
		}
		return mementos;
	}

	public Float getFloat( String key )
	{
		Object value = memento.getAttribute( key );

		if ( value != null )
		{
			try
			{
				return new Float( value.toString( ) );
			}
			catch ( NumberFormatException eNumberFormat )
			{
			}
		}

		return null;
	}

	public String getID( )
	{
		return memento.getKey( );
	}

	public Integer getInteger( String key )
	{
		Object value = memento.getAttribute( key );

		if ( value != null )
		{
			try
			{
				return new Integer( value.toString( ) );
			}
			catch ( NumberFormatException eNumberFormat )
			{
			}
		}

		return null;
	}

	public String getString( String key )
	{
		Object value = memento.getAttribute( key );

		if ( value != null )
		{
			return value.toString( );
		}

		return null;
	}

	public String getTextData( )
	{
		Object value = memento.getValue( );
		if ( value != null )
		{
			return value.toString( );
		}

		return null;
	}

	public void putFloat( String key, float value )
	{
		// TODO Auto-generated method stub

	}

	public void putInteger( String key, int value )
	{
		// TODO Auto-generated method stub

	}

	public void putMemento( IMemento memento )
	{
		// TODO Auto-generated method stub

	}

	public void putString( String key, String value )
	{
		// TODO Auto-generated method stub

	}

	public void putTextData( String data )
	{
		// TODO Auto-generated method stub

	}

	public MementoElement getMementoElement( )
	{
		return memento;
	}


	
	public MementoBuilder getBuilder( )
	{
		return builder;
	}


	
	public void setBuilder( MementoBuilder builder )
	{
		this.builder = builder;
	}


	public String[] getAttributeKeys( )
	{
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean getBoolean( String key )
	{
		// TODO Auto-generated method stub
		return Boolean.FALSE;
	}


	public String getType( )
	{
		// TODO Auto-generated method stub
		return null;
	}


	public void putBoolean( String key, boolean value )
	{
		// TODO Auto-generated method stub
		
	}

}
