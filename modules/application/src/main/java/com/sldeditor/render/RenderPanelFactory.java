/*
 * SLD Editor - The Open Source Java SLD Editor
 *
 * Copyright (C) 2016, SCISYS UK Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sldeditor.render;

import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.sldeditor.common.output.SLDOutputInterface;
import com.sldeditor.datasource.RenderSymbolInterface;
import com.sldeditor.map.MapRender;

/**
 * A factory for creating RenderPanel objects.
 * 
 * @author Robert Ward (SCISYS)
 */
public class RenderPanelFactory {

    /** The symbol render panel map. */
    private static Map<String, RenderSymbolInterface> symbolRenderPanelMap = new HashMap<String, RenderSymbolInterface>();

    /** The map panel render. */
    private static MapRender mapPanelRender = null;

    /**
     * Gets the renderer.
     *
     * @param className the class name
     * @return the renderer
     */
    public static RenderSymbolInterface getRenderer(String className)
    {
        if(!symbolRenderPanelMap.containsKey(className))
        {
            symbolRenderPanelMap.put(className, new RenderPanelImpl());
        }

        return symbolRenderPanelMap.get(className);
    }

    /**
     * Adds the sld output listener.
     *
     * @param sldOutput the sld output
     */
    public static void addSLDOutputListener(SLDOutputInterface sldOutput) {
        for(String key : symbolRenderPanelMap.keySet())
        {
            RenderSymbolInterface render = symbolRenderPanelMap.get(key);

            render.addSLDOutputListener(sldOutput);
        }
    }

    /**
     * Returns the panel containing the render symbol and the render option panel.
     *
     * @param renderSymbol the render symbol
     * @param rendererList the renderer list
     * @return the combined panel
     */
    public static JPanel getRenderOptionPanel(RenderSymbolInterface renderSymbol, List<RenderSymbolInterface> rendererList) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add((Component) renderSymbol);

        RenderOptionsPanel renderOptionPanel = new RenderOptionsPanel(renderSymbol, rendererList);
        panel.add(renderOptionPanel);
        
        return panel;
    }

    /**
     * Gets the map renderer.
     *
     * @return the map renderer
     */
    public static MapRender getMapRenderer() {
        if(mapPanelRender == null)
        {
            mapPanelRender = new MapRender();
        }

        return mapPanelRender;
    }

}
